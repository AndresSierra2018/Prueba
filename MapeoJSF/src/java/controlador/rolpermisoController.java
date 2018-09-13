/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Permiso;
import entidades.Rol;
import entidades.RolPermiso;
import facade.RolPermisoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author user
 */
@Named(value = "rolpermisoController")
@SessionScoped
public class rolpermisoController implements Serializable {

    /**
     * Creates a new instance of rolpermisoController
     */
    public rolpermisoController() {
        
        rol = new Rol();
        permiso = new Permiso();
        rolpermiso = new RolPermiso();
    }
    
    @EJB
    RolPermisoFacade rolpermisoFacade;
    private Rol rol;
    private Permiso permiso;
    private RolPermiso rolpermiso;

    public RolPermiso getRolpermiso() {
        return rolpermiso;
    }

    public void setRolpermiso(RolPermiso rolpermiso) {
        this.rolpermiso = rolpermiso;
    }
    
    
    public List<RolPermiso> listarRolesPermisos(){
    return rolpermisoFacade.findAll();
    }
    
    public void registrarRolesPermisos(){
    rolpermiso.setRolesId(rol);
    rolpermiso.setPermisosId(permiso);
    rolpermisoFacade.create(rolpermiso);
    rolpermiso = new RolPermiso();
    }
    
    public void eliminarRolesPermiso(RolPermiso newRolPermiso){
    rolpermiso = newRolPermiso;
    rolpermisoFacade.remove(rolpermiso);
    rolpermiso = new RolPermiso();
    }
    public String editarRolesPermiso(RolPermiso newRolPermiso){
    rolpermiso = newRolPermiso;
    return "/RolPermiso/modificar";
    
    }
    public String editarRolesEquipos(){
    rolpermisoFacade.edit(rolpermiso);
    rolpermiso = new RolPermiso();
    return "/RolPermiso/listar";
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

}
