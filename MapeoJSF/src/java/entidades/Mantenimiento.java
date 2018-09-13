/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "mantenimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mantenimiento.findAll", query = "SELECT m FROM Mantenimiento m")
    , @NamedQuery(name = "Mantenimiento.findByIdMantenimiento", query = "SELECT m FROM Mantenimiento m WHERE m.idMantenimiento = :idMantenimiento")
    , @NamedQuery(name = "Mantenimiento.findByFecha", query = "SELECT m FROM Mantenimiento m WHERE m.fecha = :fecha")
    , @NamedQuery(name = "Mantenimiento.findByDescripcion", query = "SELECT m FROM Mantenimiento m WHERE m.descripcion = :descripcion")})
public class Mantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MANTENIMIENTO")
    private Integer idMantenimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 500)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "EQUIPO_MAN", referencedColumnName = "ID_EQUIPO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Equipo equipoMan;
    @JoinColumn(name = "USUARIO_MAN", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuarioMan;

    public Mantenimiento() {
    }

    public Mantenimiento(Integer idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public Mantenimiento(Integer idMantenimiento, Date fecha) {
        this.idMantenimiento = idMantenimiento;
        this.fecha = fecha;
    }

    public Integer getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(Integer idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Equipo getEquipoMan() {
        return equipoMan;
    }

    public void setEquipoMan(Equipo equipoMan) {
        this.equipoMan = equipoMan;
    }

    public Usuario getUsuarioMan() {
        return usuarioMan;
    }

    public void setUsuarioMan(Usuario usuarioMan) {
        this.usuarioMan = usuarioMan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMantenimiento != null ? idMantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mantenimiento)) {
            return false;
        }
        Mantenimiento other = (Mantenimiento) object;
        if ((this.idMantenimiento == null && other.idMantenimiento != null) || (this.idMantenimiento != null && !this.idMantenimiento.equals(other.idMantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Mantenimiento[ idMantenimiento=" + idMantenimiento + " ]";
    }
    
}
