 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Usuario;
import facade.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author user
 */
@Named(value = "usuarioController")
@SessionScoped
public class usuarioController implements Serializable {

    /**
     * Creates a new instance of usuarioController
     */
    public usuarioController() {
        
        usuario = new Usuario();
        usuarioLogeado = new Usuario();
        }
    
    
    
    @EJB
    UsuarioFacade usuarioFacade;
    private Usuario usuario;
    private Usuario usuarioLogeado;
    
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public List<Usuario> listarUsuarios(){
    return usuarioFacade.findAll();
    }
    
    public void registrarUsuario(){
    usuarioFacade.create(usuario);
    usuario = new Usuario();
    }
    
    public void eliminarUsuario(Usuario newUsuario){
    usuario = newUsuario;
    usuarioFacade.remove(usuario);
    usuario = new Usuario();
    }
    public String editarUsuario(Usuario newUsuario){
    usuario = newUsuario;
    return "/Usuario/modificar?faces-redirect=true";
    
    }
    public String editarUsuario(){
    usuarioFacade.edit(usuario);
    usuario = new Usuario();
    
    return "/Usuario/listar?faces-redirect=true";
    }
    public String login(){
        Usuario user;
        
        String redireccion = "";
        
        
        user = usuarioFacade.login(usuario.getCodigo(), usuario.getContraseña());
        if(user!=null){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario",user);
            usuarioLogeado = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            redireccion = "/Usuario/listar?faces-redirect=true";
            
        }else{
            System.out.println("Usuario o contraseña incorrectos");
            redireccion = "/index?faces-redirect=true";
        }
        return redireccion;
        
        
        
    }

    public Usuario getUsuarioLogeado() {
        return usuarioLogeado;
    }

    public void setUsuarioLogeado(Usuario usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
    }

    public String cerrarSesion (){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        usuarioLogeado = new Usuario ();
        return "/index?faces-redirect=true";
    }
}
