/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Ubicacion;
import facade.UbicacionFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author user
 */
@Named(value = "ubicacionController")
@SessionScoped
public class ubicacionController implements Serializable {

    /**
     * Creates a new instance of ubicacionController
     */
    public ubicacionController() {
        ubicacion = new Ubicacion();
    }
    @EJB
    UbicacionFacade ubicacionFacade;
    private Ubicacion ubicacion;

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public List<Ubicacion> listarUbicaciones(){
    return ubicacionFacade.findAll();
    }
    
    public void registrarUbicacion(){
    ubicacionFacade.create(ubicacion);
    ubicacion = new Ubicacion();
    }
    
    public void eliminarUbicacion(Ubicacion newUbicacion){
    ubicacion = newUbicacion;
    ubicacionFacade.remove(ubicacion);
    ubicacion = new Ubicacion();
    }
    public String editarUbicacion(Ubicacion newUbicacion){
    ubicacion = newUbicacion;
    return "/Ubicacion/modificar";
    
    }
    public String editarUbicacion(){
    ubicacionFacade.edit(ubicacion);
    ubicacion = new Ubicacion();
    return "/Ubicacion/listar";
    }
}
