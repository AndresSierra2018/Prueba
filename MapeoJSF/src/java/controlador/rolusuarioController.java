/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Rol;
import entidades.RolUsuario;
import entidades.Usuario;
import facade.RolUsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author user
 */
@Named(value = "rolusuarioController")
@SessionScoped
public class rolusuarioController implements Serializable {

    /**
     * Creates a new instance of rolusuarioController
     */
    public rolusuarioController() {
        
        rolUsuario = new RolUsuario();
        usuario = new Usuario();
        rol = new Rol();
    }
    
    @EJB
    RolUsuarioFacade rolUsuarioFacade;
    private Usuario usuario;
    private Rol rol;
    private RolUsuario rolUsuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public RolUsuario getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(RolUsuario rolUsuario) {
        this.rolUsuario = rolUsuario;
    }
    
    public List<RolUsuario> listarRolesUsuarios(){
    return rolUsuarioFacade.findAll();
    }
    
    public void registrarRolesUsuarios(){
    rolUsuario.setUsuarioId(usuario);
    rolUsuario.setRolesId(rol);
    rolUsuarioFacade.create(rolUsuario);
    rolUsuario = new RolUsuario();
    }
    
    public void eliminarRolesUsuarios(RolUsuario newRolUsuario){
    rolUsuario = newRolUsuario;
    rolUsuarioFacade.remove(rolUsuario);
    rolUsuario = new RolUsuario();
    }
    public String editarRolesUsuarios(RolUsuario newRolUsuario){
    rolUsuario = newRolUsuario;
    return "/RolUsuario/modificar";   
    }
    public String editarRolesUsuarios(){
    rolUsuarioFacade.edit(rolUsuario);
    rolUsuario = new RolUsuario();
    return "/RolUsuario/listar";
    }
    
}
