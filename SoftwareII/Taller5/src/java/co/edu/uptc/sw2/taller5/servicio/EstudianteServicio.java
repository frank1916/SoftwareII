package co.edu.uptc.sw2.taller5.servicio;

import co.edu.uptc.sw2.taller5.dto.*;
import co.edu.uptc.sw2.taller5.dto.EstudianteDTO;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 * @author daperador
 * @generated
 */
@Stateless
@Path("/Estudiante")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstudianteServicio {

    @EJB
//    private EstudianteLogica logica;

    /**
     * retorna una lista con los Estudiante que se encuentran en la base de
     * datos
     *
     * @return retorna una lista de EstudianteDTO
     * @generated
     */
    @GET
    public List<EstudianteDTO> obtenerTodosEstudiantes() {
        return ProveedorInformacion.instance().obtenerTodos(EstudianteDTO.class);
    }

    /**
     * @param id identificador del elemento Estudiante
     * @return Estudiante del id dado
     * @generated
     */
    @GET
    @Path("/{id}")
    public EstudianteDTO obtenerEstudiante(@PathParam("id") Long id) {
        return (EstudianteDTO) ProveedorInformacion.instance().obtener(EstudianteDTO.class, id);
    }
    
    /**
     * 
     * @param nombre identificador del elemento Estudiante
     * @return Estudiante del nombre dado
     */
//    @GET
//    @QueryParam("/{nombre}")
//    public EstudianteDTO obtenerEstudianteNombre (@QueryParam("nombre") String nombre){
//        return (EstudianteDTO) ProveedorInformacion.instance().obtener(EstudianteDTO.class, nombre);
//    }
    
    /**
     * almacena la informacion de Estudiante
     *
     * @param dto Estudiante a guardar
     * @return Estudiante con los cambios realizados por el proceso de guardar
     * @generated
     */
    @POST
    public EstudianteDTO guardarEstudiante(EstudianteDTO dto) {
        return (EstudianteDTO) ProveedorInformacion.instance().guardar(dto);
    }

    /**
     * elimina el registro Estudiante con el identificador dado
     *
     * @param id identificador del Estudiante
     * @generated
     */
    @DELETE
    @Path("/{id}")
    public void borrarEstudiante(@PathParam("id") Long id) {
       ProveedorInformacion.instance().eliminar(EstudianteDTO.class, id);
    }

}
