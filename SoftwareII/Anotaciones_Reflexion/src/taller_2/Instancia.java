package taller_2;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 *
 */
public class Instancia {

    public static Ascensor newAscensor() {
        try {
            return (Ascensor) newInstancia(Ascensor.class);
        } catch (Exception e) {
            throw new RuntimeException(
                    "No se pudo crear una nueva instancia de la clase: ", e);
        }
    }

    public static Object newInstancia(Class clase) throws Exception {
        //crear un nuevo archivo con el proxy
        File src = new File("src");
        File f = new File(src, clase.getCanonicalName().replaceAll("\\.", "/")
                + "Proxy.java");
        //escribir en el archivo el código fuente requerido para el correcto 
        //funcionamiento de la anotación
        StringBuilder sb = new StringBuilder();
        sb.append("package " + clase.getPackage().getName() + ";");//package
        sb.append("public class " + clase.getSimpleName() + "Proxy extends "
                + clase.getSimpleName() + "{");

        sb.append("public " + clase.getSimpleName() + "Proxy(){");
        sb.append("super();");
        
        for (Method metodo : clase.getDeclaredMethods()) {
            if (metodo.getAnnotation(PostConstruct.class) != null) {
                sb.append(metodo.getName() + "();");
            }
        }

        sb.append("}");

        //se válida si el método esta anotado
        for (Method metodo : clase.getDeclaredMethods()) {
            if(metodo.getModifiers()==Modifier.PRIVATE){
                continue;
            }
            if (metodo.getAnnotations() != null) {
                //los modificadores son los siguientes: 
                sb.append(modifierFromString(metodo.getModifiers()) + " "
                        + metodo.getReturnType().getName() + " "
                        + metodo.getName() + "(");
                for (Parameter parametro : metodo.getParameters()) {
                    sb.append(parametro.getType().getName() + " "
                            + parametro.getName());
                }
                sb.append("){");//cierre del parentesis del metodo
                sb.append("super." + metodo.getName() + "(");
                        for (Parameter parametro : metodo.getParameters()) {
                            sb.append(parametro.getName());
                        }
                        sb.append(");");//cierre del llamado del metodo
                //procesar cada anotacion
                if (metodo.getAnnotation(InvocacionMultiple.class) != null) {
                    InvocacionMultiple anotacion = metodo.getAnnotation(
                            InvocacionMultiple.class);
                    //se llama un determinado numero de veces el método
                    for (int i = 1; i < anotacion.vecesAInvocar() - 1; i++) {
                        sb.append("super." + metodo.getName() + "(");
                        for (Parameter parametro : metodo.getParameters()) {
                            sb.append(parametro.getName());
                        }
                        sb.append(");");//cierre del llamado del metodo
                    }
                    //llama finalmente el metodo el elemento padre
                    sb.append("super." + metodo.getName() + "(");
                    for (Parameter parametro : metodo.getParameters()) {
                        sb.append(parametro.getName());
                    }
                    sb.append(");");//cierre del llamado del metodo
                }
                sb.append("}");//cierre de la definición del metodo proxy
            }
        }
        sb.append("}");//cierre de la definición de la clase proxy
        //almacenar el codigo en el archivo
        FileWriter fw = new FileWriter(f);
        fw.write(sb.toString());
        fw.flush();
        fw.close();

        //se compila la clase proxy
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, f.getPath());

        //se incluye en el classpath
        URLClassLoader classLoader = URLClassLoader.newInstance(
                new URL[]{src.toURI().toURL()});
        Class<?> cls = Class.forName(clase.getCanonicalName() + "Proxy",
                true, classLoader);

        //borramos el archivo
//        f.delete();
        new File(src, clase.getCanonicalName().replaceAll("\\.", "/")
                + "Proxy.class").delete();

        //devuelve la instancia
        return cls.newInstance();
    }

    private static String modifierFromString(int m) {
        switch (m) {
            case Modifier.PUBLIC:
                return "public";
            case Modifier.PROTECTED:
                return "protected";
            case Modifier.PRIVATE:
                return "private";
            case Modifier.STATIC:
                return "static";
            case Modifier.FINAL:
                return "final";
            case Modifier.TRANSIENT:
                return "transient";
            case Modifier.VOLATILE:
                return "volatile";
        }
        return null;
    }

}
