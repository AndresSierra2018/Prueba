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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuario.findByTipoUsuario", query = "SELECT u FROM Usuario u WHERE u.tipoUsuario = :tipoUsuario")
    , @NamedQuery(name = "Usuario.findByAutoridadId", query = "SELECT u FROM Usuario u WHERE u.autoridadId = :autoridadId")
    , @NamedQuery(name = "Usuario.findByNombres", query = "SELECT u FROM Usuario u WHERE u.nombres = :nombres")
    , @NamedQuery(name = "Usuario.findByApellidos", query = "SELECT u FROM Usuario u WHERE u.apellidos = :apellidos")
    , @NamedQuery(name = "Usuario.findByCodigo", query = "SELECT u FROM Usuario u WHERE u.codigo = :codigo")
    , @NamedQuery(name = "Usuario.findByCargo", query = "SELECT u FROM Usuario u WHERE u.cargo = :cargo")
    , @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")
    , @NamedQuery(name = "Usuario.findByExtension", query = "SELECT u FROM Usuario u WHERE u.extension = :extension")
    , @NamedQuery(name = "Usuario.findByMovil", query = "SELECT u FROM Usuario u WHERE u.movil = :movil")
    , @NamedQuery(name = "Usuario.findByContrase\u00f1a", query = "SELECT u FROM Usuario u WHERE u.contrase\u00f1a = :contrase\u00f1a")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TIPO_USUARIO")
    private String tipoUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AUTORIDAD_ID")
    private int autoridadId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "NOMBRES")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Size(max = 10)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CARGO")
    private String cargo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EXTENSION")
    private int extension;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MOVIL")
    private String movil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CONTRASE\u00d1A")
    private String contraseña;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioProg", fetch = FetchType.EAGER)
    private List<ProgramacionMantenimiento> programacionMantenimientoList;
    @OneToMany(mappedBy = "operadorAsignado", fetch = FetchType.EAGER)
    private List<ProgramacionMantenimiento> programacionMantenimientoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operadorId", fetch = FetchType.EAGER)
    private List<Solicitud> solicitudList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitanteId", fetch = FetchType.EAGER)
    private List<Solicitud> solicitudList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioMan", fetch = FetchType.EAGER)
    private List<Mantenimiento> mantenimientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId", fetch = FetchType.EAGER)
    private List<RolUsuario> rolUsuarioList;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String tipoUsuario, int autoridadId, String nombres, String apellidos, String cargo, String email, int extension, String movil, String contraseña) {
        this.idUsuario = idUsuario;
        this.tipoUsuario = tipoUsuario;
        this.autoridadId = autoridadId;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cargo = cargo;
        this.email = email;
        this.extension = extension;
        this.movil = movil;
        this.contraseña = contraseña;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public int getAutoridadId() {
        return autoridadId;
    }

    public void setAutoridadId(int autoridadId) {
        this.autoridadId = autoridadId;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @XmlTransient
    public List<ProgramacionMantenimiento> getProgramacionMantenimientoList() {
        return programacionMantenimientoList;
    }

    public void setProgramacionMantenimientoList(List<ProgramacionMantenimiento> programacionMantenimientoList) {
        this.programacionMantenimientoList = programacionMantenimientoList;
    }

    @XmlTransient
    public List<ProgramacionMantenimiento> getProgramacionMantenimientoList1() {
        return programacionMantenimientoList1;
    }

    public void setProgramacionMantenimientoList1(List<ProgramacionMantenimiento> programacionMantenimientoList1) {
        this.programacionMantenimientoList1 = programacionMantenimientoList1;
    }

    @XmlTransient
    public List<Solicitud> getSolicitudList() {
        return solicitudList;
    }

    public void setSolicitudList(List<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
    }

    @XmlTransient
    public List<Solicitud> getSolicitudList1() {
        return solicitudList1;
    }

    public void setSolicitudList1(List<Solicitud> solicitudList1) {
        this.solicitudList1 = solicitudList1;
    }

    @XmlTransient
    public List<Mantenimiento> getMantenimientoList() {
        return mantenimientoList;
    }

    public void setMantenimientoList(List<Mantenimiento> mantenimientoList) {
        this.mantenimientoList = mantenimientoList;
    }

    @XmlTransient
    public List<RolUsuario> getRolUsuarioList() {
        return rolUsuarioList;
    }

    public void setRolUsuarioList(List<RolUsuario> rolUsuarioList) {
        this.rolUsuarioList = rolUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
