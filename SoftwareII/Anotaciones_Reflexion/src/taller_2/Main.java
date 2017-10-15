package taller_2;


/**
 *
 *
 */
public class Main {

    public static void main(String[] args) {
        Ascensor ascensor = Instancia.newAscensor();
        ascensor.subir2Pisos();
        ascensor.subir1Piso();
        ascensor.bajar3Pisos();
        ascensor.subir1Piso();
        ascensor.bajar1Piso();
    }

}
