/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author FSN-Desarrollo
 */
@Entity
@Table(name = "desafectacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Desafectacion.findAll", query = "SELECT d FROM Desafectacion d"),
    @NamedQuery(name = "Desafectacion.findByIddesafectacion", query = "SELECT d FROM Desafectacion d WHERE d.iddesafectacion = :iddesafectacion"),
    @NamedQuery(name = "Desafectacion.findByIngresodesafectacion", query = "SELECT d FROM Desafectacion d WHERE d.ingresodesafectacion = :ingresodesafectacion"),
    @NamedQuery(name = "Desafectacion.findByFechacrea", query = "SELECT d FROM Desafectacion d WHERE d.fechacrea = :fechacrea"),
    @NamedQuery(name = "Desafectacion.findByFechaauto", query = "SELECT d FROM Desafectacion d WHERE d.fechaauto = :fechaauto"),
    @NamedQuery(name = "Desafectacion.findByNumactajd", query = "SELECT d FROM Desafectacion d WHERE d.numactajd = :numactajd"),
    @NamedQuery(name = "Desafectacion.findByFechaacta", query = "SELECT d FROM Desafectacion d WHERE d.fechaacta = :fechaacta"),
    @NamedQuery(name = "Desafectacion.findByNumreporterobo", query = "SELECT d FROM Desafectacion d WHERE d.numreporterobo = :numreporterobo"),
    @NamedQuery(name = "Desafectacion.findByFechadesafectacion", query = "SELECT d FROM Desafectacion d WHERE d.fechadesafectacion = :fechadesafectacion")})
public class Desafectacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddesafectacion")
    private Integer iddesafectacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ingresodesafectacion")
    private BigDecimal ingresodesafectacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacrea")
    @Temporal(TemporalType.DATE)
    private Date fechacrea;
    @Column(name = "fechaauto")
    @Temporal(TemporalType.DATE)
    private Date fechaauto;
    @Column(name = "numactajd")
    private Integer numactajd;
    @Column(name = "fechaacta")
    @Temporal(TemporalType.DATE)
    private Date fechaacta;
    @Column(name = "numreporterobo")
    private Integer numreporterobo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechadesafectacion")
    @Temporal(TemporalType.DATE)
    private Date fechadesafectacion;
    @JoinColumn(name = "idempleado", referencedColumnName = "idempleado")
    @ManyToOne
    private Empleado idempleado;
    @JoinColumn(name = "emp_idempleado", referencedColumnName = "idempleado")
    @ManyToOne
    private Empleado empIdempleado;
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @ManyToOne
    private Persona idpersona;
    @JoinColumn(name = "idtipodesafectacion", referencedColumnName = "idtipodesafectacion")
    @ManyToOne
    private Tipodesafectacion idtipodesafectacion;

    public Desafectacion() {
    }

    public Desafectacion(Integer iddesafectacion) {
        this.iddesafectacion = iddesafectacion;
    }

    public Desafectacion(Integer iddesafectacion, Date fechacrea, Date fechadesafectacion) {
        this.iddesafectacion = iddesafectacion;
        this.fechacrea = fechacrea;
        this.fechadesafectacion = fechadesafectacion;
    }

    public Integer getIddesafectacion() {
        return iddesafectacion;
    }

    public void setIddesafectacion(Integer iddesafectacion) {
        this.iddesafectacion = iddesafectacion;
    }

    public BigDecimal getIngresodesafectacion() {
        return ingresodesafectacion;
    }

    public void setIngresodesafectacion(BigDecimal ingresodesafectacion) {
        this.ingresodesafectacion = ingresodesafectacion;
    }

    public Date getFechacrea() {
        return fechacrea;
    }

    public void setFechacrea(Date fechacrea) {
        this.fechacrea = fechacrea;
    }

    public Date getFechaauto() {
        return fechaauto;
    }

    public void setFechaauto(Date fechaauto) {
        this.fechaauto = fechaauto;
    }

    public Integer getNumactajd() {
        return numactajd;
    }

    public void setNumactajd(Integer numactajd) {
        this.numactajd = numactajd;
    }

    public Date getFechaacta() {
        return fechaacta;
    }

    public void setFechaacta(Date fechaacta) {
        this.fechaacta = fechaacta;
    }

    public Integer getNumreporterobo() {
        return numreporterobo;
    }

    public void setNumreporterobo(Integer numreporterobo) {
        this.numreporterobo = numreporterobo;
    }

    public Date getFechadesafectacion() {
        return fechadesafectacion;
    }

    public void setFechadesafectacion(Date fechadesafectacion) {
        this.fechadesafectacion = fechadesafectacion;
    }

    public Empleado getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Empleado idempleado) {
        this.idempleado = idempleado;
    }

    public Empleado getEmpIdempleado() {
        return empIdempleado;
    }

    public void setEmpIdempleado(Empleado empIdempleado) {
        this.empIdempleado = empIdempleado;
    }

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
    }

    public Tipodesafectacion getIdtipodesafectacion() {
        return idtipodesafectacion;
    }

    public void setIdtipodesafectacion(Tipodesafectacion idtipodesafectacion) {
        this.idtipodesafectacion = idtipodesafectacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddesafectacion != null ? iddesafectacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Desafectacion)) {
            return false;
        }
        Desafectacion other = (Desafectacion) object;
        if ((this.iddesafectacion == null && other.iddesafectacion != null) || (this.iddesafectacion != null && !this.iddesafectacion.equals(other.iddesafectacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Desafectacion[ iddesafectacion=" + iddesafectacion + " ]";
    }
    
}
