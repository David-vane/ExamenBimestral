/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Modelo.Cliente;
import Modelo.Vehiculo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
@Path("modelo.vehiculo")
public class VehiculoFacadeREST extends AbstractFacade<Vehiculo> {

    @PersistenceContext(unitName = "LojacarPU")
    private EntityManager em;

    public VehiculoFacadeREST() {
        super(Vehiculo.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Vehiculo entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Vehiculo entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Vehiculo find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Vehiculo> findAll() {
        return super.findAll();
    }

    @POST
    @Path("crear")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String crear (@FormParam("idVehiculo")int idVehiculo,@FormParam("año")int año,@FormParam("numPasageros")int numPasajeros,@FormParam("modelo")String modelo,
            @FormParam("marca")String marca,@FormParam("cilindraje")int cilindraje,@FormParam("paisFabrica")String paisFabrica,@FormParam("placa")String placa,@FormParam("concensionario")String concensionario) {
        Vehiculo ob =new Vehiculo(idVehiculo, año, numPasajeros, modelo, marca, cilindraje, paisFabrica, placa, concensionario);
        super.create(ob);
        return "el objeto se inserto con exito";  
    }
    
    @POST
    @Path("editar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String editar (@FormParam("idVehiculo")int idVehiculo,@FormParam("año")int año,@FormParam("numPasageros")int numPasajeros,@FormParam("modelo")String modelo,
            @FormParam("marca")String marca,@FormParam("cilindraje")int cilindraje,@FormParam("paisFabrica")String paisFabrica,@FormParam("placa")String placa,@FormParam("concensionario")String concensionario) {
        Vehiculo cl = super.find(idVehiculo);
        if(idVehiculo==idVehiculo){
        cl.setAño(año);
        cl.setCilindraje(cilindraje);
        cl.setConcensionario(concensionario);
        cl.setIDVehiculo(idVehiculo);
        cl.setMarca(marca);
        cl.setModelo(modelo);
        cl.setNumPasajeros(numPasajeros);
        cl.setPaisFabrica(paisFabrica);
        cl.setPlaca(placa);
        super.edit(cl);
           return ("se actualizo con exito");
        }else{
            return("no se puede editar");
        }
    }
    
    @POST
    @Path("consultaVehiculo")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Vehiculo> leerPasajeros(@FormParam("numPasajeros")int numPasajeros){
           TypedQuery consulta = getEntityManager().createQuery("SELECT v FROM Vehiculo v WHERE v.placa = :placa", Vehiculo.class);
    consulta.setParameter("numPasajeros", numPasajeros);
    return consulta.getResultList();
    }
    
    @POST
    @Path("consultarvehiculosvendidos")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Cliente> leerJoyeria(@FormParam("concensionario")String concensionario){
           TypedQuery consulta = getEntityManager().createQuery("SELECT c FROM Cliente c WHERE c.idVehiculo = :idVehiculo", Cliente.class);
    consulta.setParameter("concensionario", concensionario);
    return consulta.getResultList();
    }
    
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vehiculo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
