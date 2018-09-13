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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "programacion_mantenimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramacionMantenimiento.findAll", query = "SELECT p FROM ProgramacionMantenimiento p")
    , @NamedQuery(name = "ProgramacionMantenimiento.findByIdProgramacion", query = "SELECT p FROM ProgramacionMantenimiento p WHERE p.idProgramacion = :idProgramacion")
    , @NamedQuery(name = "ProgramacionMantenimiento.findByFecha", query = "SELECT p FROM ProgramacionMantenimiento p WHERE p.fecha = :fecha")})
public class ProgramacionMantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PROGRAMACION")
    private Integer idProgramacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "EQUIPO_PROG", referencedColumnName = "ID_EQUIPO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Equipo equipoProg;
    @JoinColumn(name = "USUARIO_PROG", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuarioProg;
    @JoinColumn(name = "OPERADOR_ASIGNADO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario operadorAsignado;

    public ProgramacionMantenimiento() {
    }

    public ProgramacionMantenimiento(Integer idProgramacion) {
        this.idProgramacion = idProgramacion;
    }

    public ProgramacionMantenimiento(Integer idProgramacion, Date fecha) {
        this.idProgramacion = idProgramacion;
        this.fecha = fecha;
    }

    public Integer getIdProgramacion() {
        return idProgramacion;
    }

    public void setIdProgramacion(Integer idProgramacion) {
        this.idProgramacion = idProgramacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Equipo getEquipoProg() {
        return equipoProg;
    }

    public void setEquipoProg(Equipo equipoProg) {
        this.equipoProg = equipoProg;
    }

    public Usuario getUsuarioProg() {
        return usuarioProg;
    }

    public void setUsuarioProg(Usuario usuarioProg) {
        this.usuarioProg = usuarioProg;
    }

    public Usuario getOperadorAsignado() {
        return operadorAsignado;
    }

    public void setOperadorAsignado(Usuario operadorAsignado) {
        this.operadorAsignado = operadorAsignado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProgramacion != null ? idProgramacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramacionMantenimiento)) {
            return false;
        }
        ProgramacionMantenimiento other = (ProgramacionMantenimiento) object;
        if ((this.idProgramacion == null && other.idProgramacion != null) || (this.idProgramacion != null && !this.idProgramacion.equals(other.idProgramacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ProgramacionMantenimiento[ idProgramacion=" + idProgramacion + " ]";
    }
    
}
