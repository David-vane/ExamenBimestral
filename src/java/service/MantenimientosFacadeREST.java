/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Modelo.Mantenimientos;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Robin
 */
@Stateless
@Path("modelo.mantenimientos")
public class MantenimientosFacadeREST extends AbstractFacade<Mantenimientos> {

    @PersistenceContext(unitName = "LojacarPU")
    private EntityManager em;

    public MantenimientosFacadeREST() {
        super(Mantenimientos.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Mantenimientos entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Date id, Mantenimientos entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Date id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Mantenimientos find(@PathParam("id") Date id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Mantenimientos> findAll() {
        return super.findAll();
    }
    
    @POST
    @Path("crear")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String crear (@FormParam("idVehiculo")int idVehiculo,@FormParam("cedulaClientre")String cedulaCliente,@FormParam("fechaMan")Date fechaMan,@FormParam("descripcion")String descripcion,
            @FormParam("kilometrajeVehiculo")int kilometrajeVehiculo) {
        Mantenimientos objeto =new Mantenimientos(idVehiculo, cedulaCliente, fechaMan, descripcion, kilometrajeVehiculo);
        super.create(objeto);
        return "el objeto se inserto con exito";  
    }

    @POST
    @Path("editar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String editar (@FormParam("idVehiculo")int idVehiculo,@FormParam("cedulaClientre")String cedulaCliente,@FormParam("fechaMan")Date fechaMan,@FormParam("descripcion")String descripcion,
            @FormParam("kilometrajeVehiculo")int kilometrajeVehiculo) {
        Mantenimientos cl = super.find(fechaMan);
        if(fechaMan==fechaMan){
        cl.setCedulaCliente(cedulaCliente);
        cl.setDescripcion(descripcion);
        cl.setFechaMan(fechaMan);
        cl.setIdVehiculo(idVehiculo);
        cl.setKilometrajeVehiculo(kilometrajeVehiculo);
        super.edit(cl);
           return ("se actualizo con exito");
        }else{
            return("no se puede editar");
        }
    }
    
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Mantenimientos> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
