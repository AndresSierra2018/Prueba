/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e")
    , @NamedQuery(name = "Equipo.findByIdEquipo", query = "SELECT e FROM Equipo e WHERE e.idEquipo = :idEquipo")
    , @NamedQuery(name = "Equipo.findByPlaca", query = "SELECT e FROM Equipo e WHERE e.placa = :placa")
    , @NamedQuery(name = "Equipo.findByTipo", query = "SELECT e FROM Equipo e WHERE e.tipo = :tipo")
    , @NamedQuery(name = "Equipo.findByMarca", query = "SELECT e FROM Equipo e WHERE e.marca = :marca")
    , @NamedQuery(name = "Equipo.findByCaracteristicas", query = "SELECT e FROM Equipo e WHERE e.caracteristicas = :caracteristicas")})
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EQUIPO")
    private Integer idEquipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PLACA")
    private String placa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "TIPO")
    private String tipo;
    @Size(max = 500)
    @Column(name = "MARCA")
    private String marca;
    @Size(max = 500)
    @Column(name = "CARACTERISTICAS")
    private String caracteristicas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipoProg", fetch = FetchType.EAGER)
    private List<ProgramacionMantenimiento> programacionMantenimientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipoId", fetch = FetchType.EAGER)
    private List<Solicitud> solicitudList;
    @JoinColumn(name = "UBICACION_ID", referencedColumnName = "ID_UBICACION")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Ubicacion ubicacionId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipoMan", fetch = FetchType.EAGER)
    private List<Mantenimiento> mantenimientoList;

    public Equipo() {
    }

    public Equipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Equipo(Integer idEquipo, String placa, String tipo) {
        this.idEquipo = idEquipo;
        this.placa = placa;
        this.tipo = tipo;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    @XmlTransient
    public List<ProgramacionMantenimiento> getProgramacionMantenimientoList() {
        return programacionMantenimientoList;
    }

    public void setProgramacionMantenimientoList(List<ProgramacionMantenimiento> programacionMantenimientoList) {
        this.programacionMantenimientoList = programacionMantenimientoList;
    }

    @XmlTransient
    public List<Solicitud> getSolicitudList() {
        return solicitudList;
    }

    public void setSolicitudList(List<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
    }

    public Ubicacion getUbicacionId() {
        return ubicacionId;
    }

    public void setUbicacionId(Ubicacion ubicacionId) {
        this.ubicacionId = ubicacionId;
    }

    @XmlTransient
    public List<Mantenimiento> getMantenimientoList() {
        return mantenimientoList;
    }

    public void setMantenimientoList(List<Mantenimiento> mantenimientoList) {
        this.mantenimientoList = mantenimientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipo != null ? idEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.idEquipo == null && other.idEquipo != null) || (this.idEquipo != null && !this.idEquipo.equals(other.idEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Equipo[ idEquipo=" + idEquipo + " ]";
    }
    
}
