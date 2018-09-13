/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Permiso;
import facade.PermisoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author user
 */
@Named(value = "controllerPermiso")
@SessionScoped
public class controllerPermiso implements Serializable {

    /**
     * Creates a new instance of controllerPermiso
     */
    public controllerPermiso() {
        permiso = new Permiso();
    }
    
    @EJB
    PermisoFacade permisoFacade;
    private Permiso permiso;

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }
    
    public List<Permiso> listarPermisos(){
    return permisoFacade.findAll();
    }
    
    public void registrarPermiso(){
    permisoFacade.create(permiso);
    permiso = new Permiso();
    }
    
    public void eliminarPermiso(Permiso newPermiso){
    permiso = newPermiso;
    permisoFacade.remove(permiso);
    permiso = new Permiso();
    }
    
    public String editarPermiso(Permiso newPermiso){
    permiso = newPermiso;
    return "/Permiso/modificar";
    }
    
    public String editarPermiso(){
    permisoFacade.edit(permiso);
    permiso = new Permiso();
    return "/Permiso/listar";
    }
}
