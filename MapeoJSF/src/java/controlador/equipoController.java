/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Equipo;
import entidades.Ubicacion;
import facade.EquipoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author user
 */
@Named(value = "equipoController")
@SessionScoped
public class equipoController implements Serializable {

    /**
     * Creates a new instance of equipoController
     */
    public equipoController() {
        ubicacion = new Ubicacion();
        equipo = new Equipo();
    }
    
    @EJB
    EquipoFacade equipoFacade;
    private Ubicacion ubicacion;
    private Equipo equipo;

    public Equipo getEquipo() {
        return equipo;
    }
    
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    
    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    
    public List<Equipo> listarEquipos(){
    return equipoFacade.findAll();
    }
    
    public void registrarEquipo(){
    equipo.setUbicacionId(ubicacion);
    equipoFacade.create(equipo);
    equipo = new Equipo();
    }
    
    public void eliminarEquipo(Equipo newEquipo){
    equipo = newEquipo;
    equipoFacade.remove(equipo);
    equipo = new Equipo();
    }
    public String editarEquipo(Equipo newEquipo){
    equipo = newEquipo;
    return "/Equipo/modificar";
    
    }
    public String editarEquipo(){
    equipo.setUbicacionId(ubicacion);
    equipoFacade.edit(equipo);
    equipo = new Equipo();
    return "/Equipo/listar";
    }

    
    
}
