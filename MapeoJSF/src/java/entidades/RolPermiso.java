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
@Table(name = "roles_permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolPermiso.findAll", query = "SELECT r FROM RolPermiso r")
    , @NamedQuery(name = "RolPermiso.findByIdRolper", query = "SELECT r FROM RolPermiso r WHERE r.idRolper = :idRolper")})
public class RolPermiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ROLPER")
    private Integer idRolper;
    @JoinColumn(name = "ROLES_ID", referencedColumnName = "ID_ROLES")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Rol rolesId;
    @JoinColumn(name = "PERMISOS_ID", referencedColumnName = "ID_PERMISOS")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Permiso permisosId;

    public RolPermiso() {
    }

    public RolPermiso(Integer idRolper) {
        this.idRolper = idRolper;
    }

    public Integer getIdRolper() {
        return idRolper;
    }

    public void setIdRolper(Integer idRolper) {
        this.idRolper = idRolper;
    }

    public Rol getRolesId() {
        return rolesId;
    }

    public void setRolesId(Rol rolesId) {
        this.rolesId = rolesId;
    }

    public Permiso getPermisosId() {
        return permisosId;
    }

    public void setPermisosId(Permiso permisosId) {
        this.permisosId = permisosId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRolper != null ? idRolper.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolPermiso)) {
            return false;
        }
        RolPermiso other = (RolPermiso) object;
        if ((this.idRolper == null && other.idRolper != null) || (this.idRolper != null && !this.idRolper.equals(other.idRolper))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.RolPermiso[ idRolper=" + idRolper + " ]";
    }
    
}
