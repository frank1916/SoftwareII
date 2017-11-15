package co.edu.uptc.bochica.persistencia.entidad;

import java.util.Date;
import javax.persistence.*;

//@Entity
//@Table(name = "DosisAplicada")//, schema="${schema}")
//@NamedQueries({
//    @NamedQuery(name = "DosisAplicada.obtenerTodos", query = "select e from Dosis e")
//})
public class DosisAplicada {

    @Id
//    @Column(name = "DosisAplicada_id")
//    @GeneratedValue(generator = "DosisAplicadaGen", strategy = GenerationType.SEQUENCE)
//    @SequenceGenerator(name = "DosisAplicadaGen", sequenceName = "DosisAplicada_SEQ", allocationSize = 1)
    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    private Date fecha;

//    @ManyToOne
    private Historial historial;

    
//    @ManyToOne
    private Dosis dosis;

    /**
     * @generated
     */
    public Date getFecha() {
        return this.fecha;
    }

    /**
     * @generated
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @generated
     */
    public Dosis getDosis() {
        return this.dosis;
    }

    /**
     * @generated
     */
    public void setDosis(Dosis dosis) {
        this.dosis = dosis;
    }

    /**
     * @generated
     */
    public Historial getHistorial() {
        return this.historial;
    }

    /**
     * @generated
     */
    public void setHistorial(Historial historial) {
        this.historial = historial;
    }

}
