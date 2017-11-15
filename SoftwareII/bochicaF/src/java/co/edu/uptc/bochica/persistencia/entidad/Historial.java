package co.edu.uptc.bochica.persistencia.entidad;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "Historial")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "Historial.obtenerTodos", query = "select e from Historial e")
})
public class Historial {

    @Id
    //@Column(name = "Historial_id")
    @GeneratedValue(generator = "HistorialGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "HistorialGen", sequenceName = "Historial_SEQ", allocationSize = 1)
    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    @OneToOne
    private Persona persona;

    /**
     * @generated
     */
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    /**
     * @generated
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * @generated
     */
    public Persona getPersona() {
        return this.persona;
    }

    /**
     * @generated
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
