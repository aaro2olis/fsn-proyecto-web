/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.primefaces.context.RequestContext;

/**
 *
 * @author FSN-Desarrollo
 */
@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByIdempleado", query = "SELECT e FROM Empleado e WHERE e.idempleado = :idempleado"),
    @NamedQuery(name = "Empleado.findByNombres", query = "SELECT e FROM Empleado e WHERE e.nombres = :nombres"),
    @NamedQuery(name = "Empleado.findByApepaterno", query = "SELECT e FROM Empleado e WHERE e.apepaterno = :apepaterno"),
    @NamedQuery(name = "Empleado.findByApematerno", query = "SELECT e FROM Empleado e WHERE e.apematerno = :apematerno"),
    @NamedQuery(name = "Empleado.findByCorreo", query = "SELECT e FROM Empleado e WHERE e.correo = :correo"),
    @NamedQuery(name = "Empleado.findByEstadoempleado", query = "SELECT e FROM Empleado e WHERE e.estadoempleado = :estadoempleado"),
    @NamedQuery(name = "Empleado.findByFechaini", query = "SELECT e FROM Empleado e WHERE e.fechaini = :fechaini"),
    @NamedQuery(name = "Empleado.findByFechafin", query = "SELECT e FROM Empleado e WHERE e.fechafin = :fechafin")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idempleado")
    private String idempleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 20)
    @Column(name = "apepaterno")
    private String apepaterno;
    @Size(max = 20)
    @Column(name = "apematerno")
    private String apematerno;
    @Size(max = 50)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoempleado")
    private Character estadoempleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaini")
    @Temporal(TemporalType.DATE)
    private Date fechaini;
    @Column(name = "fechafin")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @JoinColumn(name = "idcargo", referencedColumnName = "idcargo")
    @ManyToOne(optional = false)
    private Cargo idcargo;
    @JoinColumn(name = "idunidad", referencedColumnName = "idunidad")
    @ManyToOne(optional = false)
    private UnidadOrganizativa idunidad;
    @OneToMany(mappedBy = "empIdempleado")
    private Collection<Inventario> inventarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idempleado")
    private Collection<Inventario> inventarioCollection1;
    @OneToMany(mappedBy = "idempleado")
    private Collection<Desafectacion> desafectacionCollection;
    @OneToMany(mappedBy = "empIdempleado")
    private Collection<Desafectacion> desafectacionCollection1;
    @OneToMany(mappedBy = "idempleado")
    private Collection<Usuario> usuarioCollection;
    @OneToMany(mappedBy = "idempleado")
    private Collection<Activo> activoCollection;

    public Empleado() {
    }

    public Empleado(String idempleado) {
        this.idempleado = idempleado;
    }

    public Empleado(String idempleado, String nombres, Character estadoempleado, Date fechaini) {
        this.idempleado = idempleado;
        this.nombres = nombres;
        this.estadoempleado = estadoempleado;
        this.fechaini = fechaini;
    }

    public String getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(String idempleado) {
        this.idempleado = idempleado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApepaterno() {
        return apepaterno;
    }

    public void setApepaterno(String apepaterno) {
        this.apepaterno = apepaterno;
    }

    public String getApematerno() {
        return apematerno;
    }

    public void setApematerno(String apematerno) {
        this.apematerno = apematerno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Character getEstadoempleado() {
        return estadoempleado;
    }

    public String nombreEstadoDeempleado() {
        String nombreEstadoEmpleado;
        nombreEstadoEmpleado = "";
        switch (estadoempleado) {
            case '0':
                nombreEstadoEmpleado = "Eliminado";
                break;
            case '2':
                nombreEstadoEmpleado = "Retirado";
                break;
            case '1':
                nombreEstadoEmpleado = "Activo";
                break;
            default:
                nombreEstadoEmpleado = "Error";
                break;
        }
        return nombreEstadoEmpleado;
    }

    public void setEstadoempleado(Character estadoempleado) {
        if (estadoempleado == '1') {
            this.estadoempleado = '1';
        } else {
            if (estadoempleado == '2') {
                this.estadoempleado = estadoempleado;
            } else {
                this.estadoempleado = '0';
            }
        }

    }

    public void setEstadoempleado() {
        this.estadoempleado = '1';
    }

    public Date getFechaini() {
        return fechaini;
    }

    public void setFechaini(Date fechaini) {
        this.fechaini = fechaini;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        Character estado;
        estado='2';
        this.fechafin = fechafin;
        if((fechafin==null))
        {
        setEstadoempleado();
        }
        else
        {
        setEstadoempleado(estado);
        }
    }

    public Cargo getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(Cargo idcargo) {
        this.idcargo = idcargo;
    }

    public UnidadOrganizativa getIdunidad() {
        return idunidad;
    }

    public void setIdunidad(UnidadOrganizativa idunidad) {
        this.idunidad = idunidad;
    }

    @XmlTransient
    public Collection<Inventario> getInventarioCollection() {
        return inventarioCollection;
    }

    public void setInventarioCollection(Collection<Inventario> inventarioCollection) {
        this.inventarioCollection = inventarioCollection;
    }

    @XmlTransient
    public Collection<Inventario> getInventarioCollection1() {
        return inventarioCollection1;
    }

    public void setInventarioCollection1(Collection<Inventario> inventarioCollection1) {
        this.inventarioCollection1 = inventarioCollection1;
    }

    @XmlTransient
    public Collection<Desafectacion> getDesafectacionCollection() {
        return desafectacionCollection;
    }

    public void setDesafectacionCollection(Collection<Desafectacion> desafectacionCollection) {
        this.desafectacionCollection = desafectacionCollection;
    }

    @XmlTransient
    public Collection<Desafectacion> getDesafectacionCollection1() {
        return desafectacionCollection1;
    }

    public void setDesafectacionCollection1(Collection<Desafectacion> desafectacionCollection1) {
        this.desafectacionCollection1 = desafectacionCollection1;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Activo> getActivoCollection() {
        return activoCollection;
    }

    public void setActivoCollection(Collection<Activo> activoCollection) {
        this.activoCollection = activoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idempleado != null ? idempleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idempleado == null && other.idempleado != null) || (this.idempleado != null && !this.idempleado.equals(other.idempleado))) {
            return false;
        }
        return true;
    }
     public String carnet(Integer cuenta)
     {String carnet;
      cuenta=cuenta+1;
         if (cuenta<10) {
         carnet="FSN-00"+cuenta.toString();
         }
         else {
             if (cuenta<100) {
             carnet="FSN-0"+cuenta.toString();    
             }
             else{
             carnet="FSN-"+cuenta.toString();
             }
         }
    return carnet;
             }
    @Override
    public String toString() {
        return nombres + " " + apepaterno + " " + apematerno;
    }
    
}
