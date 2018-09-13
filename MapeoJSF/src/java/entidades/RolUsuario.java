/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "roles_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolUsuario.findAll", query = "SELECT r FROM RolUsuario r")
    , @NamedQuery(name = "RolUsuario.findByIdRolusu", query = "SELECT r FROM RolUsuario r WHERE r.idRolusu = :idRolusu")})
public class RolUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ROLUSU")
    private Integer idRolusu;
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuarioId;
    @JoinColumn(name = "ROLES_ID", referencedColumnName = "ID_ROLES")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Rol rolesId;

    public RolUsuario() {
    }

    public RolUsuario(Integer idRolusu) {
        this.idRolusu = idRolusu;
    }

    public Integer getIdRolusu() {
        return idRolusu;
    }

    public void setIdRolusu(Integer idRolusu) {
        this.idRolusu = idRolusu;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Rol getRolesId() {
        return rolesId;
    }

    public void setRolesId(Rol rolesId) {
        this.rolesId = rolesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRolusu != null ? idRolusu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolUsuario)) {
            return false;
        }
        RolUsuario other = (RolUsuario) object;
        if ((this.idRolusu == null && other.idRolusu != null) || (this.idRolusu != null && !this.idRolusu.equals(other.idRolusu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.RolUsuario[ idRolusu=" + idRolusu + " ]";
    }
    
}
