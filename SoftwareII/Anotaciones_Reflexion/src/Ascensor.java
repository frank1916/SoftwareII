/**
 *
 * @author 
 */
public class Ascensor {
    
    private int piso = 1;
    
    @InvocacionMultiple
    public void subir1Piso(){
        piso++;
        System.out.println("subiendo piso 1 " + piso);
    }
    
    @InvocacionMultiple(vecesInvocar = 2 )
    public void subir2Pisos(){
        piso++;
        System.out.println("Subiendo piso 2 " + piso);
    }
    
   
   @InvocacionMultiple(vecesInvocar = 3)
   public void  bajar3Pisos(){
       piso--;
       System.out.println("Bajando 3 pisos " + piso);
   }
    
    
}
