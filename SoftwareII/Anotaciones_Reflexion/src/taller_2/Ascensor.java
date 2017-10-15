package taller_2;


import javax.annotation.PostConstruct;

/**
 *
 * @author 
 */
public class Ascensor {
    
    private int piso = 3;
    
    @InvocacionMultiple
    public void subir1Piso(){
        piso++;
        System.out.println("subiendo piso 1 " + piso);
    }
    
    @InvocacionMultiple(vecesAInvocar = 2 )
    public void subir2Pisos(){
        piso++;
        System.out.println("Subiendo piso 2 " + piso);
    }
    
   
   @InvocacionMultiple(vecesAInvocar = 3)
   public void  bajar3Pisos(){
       piso--;
       System.out.println("Bajando 3 pisos " + piso);
   }
    
    public void bajar1Piso(){
        piso--;
        System.out.println("Bajando 1 piso: "+piso);
    }
    
     @PostConstruct
    public void reiniciar(){
        System.out.println("reiniciar ascensor");
        piso=1;
    }
    
}
