/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Equipo;
import entidades.Solicitud;
import entidades.Usuario;
import facade.SolicitudFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author user
 */
@Named(value = "solicitudController")
@SessionScoped
public class solicitudController implements Serializable {

    /**
     * Creates a new instance of solicitudController
     */
    public solicitudController() {
        
        
        usuario = new Usuario();
        operador = new Usuario();
        equipo = new Equipo();
        solicitud = new Solicitud();
        
    }
    @EJB
    SolicitudFacade solicitudFacade;
   
    
    private Usuario usuario;
    private Usuario operador;
    private Equipo equipo;
    private Solicitud solicitud;
   

    
    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
    
    public List<Solicitud> listarSolicitudes(){
    return solicitudFacade.findAll();
    }
    
    public void registrarSolicitud(){
    solicitud.setSolicitanteId(usuario);
    solicitud.setEquipoId(equipo);
    solicitud.setOperadorId(operador);
    solicitudFacade.create(solicitud);
    solicitud = new Solicitud();
    }
    
    
    
    public String editarSolicitud(Solicitud newSolicitud){
    solicitud = newSolicitud;
    return "/Solicitud/modificar";
    
    }
    public String editarSolicitud(){
    solicitud.setSolicitanteId(usuario);
    solicitud.setEquipoId(equipo);
    solicitud.setOperadorId(usuario);
    solicitudFacade.edit(solicitud);
    solicitud = new Solicitud();
    return "/Solicitud/listar";
    }
    
    public void eliminarSolicitud(Solicitud newSolicitud){
    solicitud = newSolicitud;
    solicitudFacade.remove(solicitud);
    solicitud = new Solicitud();
    }
    
    
    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getOperador() {
        return operador;
    }

    public void setOperador(Usuario operador) {
        this.operador = operador;
    }
    
}
