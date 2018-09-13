/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Rol;
import facade.RolFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author user
 */
@Named(value = "rolController")
@SessionScoped
public class rolController implements Serializable {

    /**
     * Creates a new instance of rolController
     */
    public rolController() {
        rol = new Rol();
    }
    
    @EJB
    RolFacade RolFacade;
    private Rol rol;

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
     public List<Rol> listarRoles(){
    return RolFacade.findAll();
    }
    
    public void registrarRol(){
    RolFacade.create(rol);
    rol = new Rol();
    }
    
    public void eliminarRol(Rol newRol){
    rol = newRol;
    RolFacade.remove(newRol);
    rol = new Rol();
    }
    
    public String editarRol(Rol newRol){
    rol = newRol;
    return "/Rol/modificar";
    }
    
    public String editarPermiso(){
    RolFacade.edit(rol);
    rol = new Rol();
    return "/Rol/listar";
    }
    
    
}
