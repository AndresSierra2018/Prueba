/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidades.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author user
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "MapeoJSFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario login(String codigo ,String contrasena ){
    Usuario usuario = null;
        try {
            Query consulta = em.createNativeQuery("select * from usuario where codigo = ? and contraseña = ?", Usuario.class);
        consulta.setParameter(1,codigo);
        consulta.setParameter(2,contrasena);
        usuario = (Usuario) consulta.getSingleResult();
        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
        }
    return usuario;
    }
    
}
