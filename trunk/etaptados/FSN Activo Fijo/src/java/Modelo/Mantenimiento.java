/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FSN-Desarrollo
 */
@Entity
@Table(name = "mantenimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mantenimiento.findAll", query = "SELECT m FROM Mantenimiento m"),
    @NamedQuery(name = "Mantenimiento.findByIdmantenimiento", query = "SELECT m FROM Mantenimiento m WHERE m.idmantenimiento = :idmantenimiento"),
    @NamedQuery(name = "Mantenimiento.findByDscmantenimiento", query = "SELECT m FROM Mantenimiento m WHERE m.dscmantenimiento = :dscmantenimiento"),
    @NamedQuery(name = "Mantenimiento.findByCostomantenimiento", query = "SELECT m FROM Mantenimiento m WHERE m.costomantenimiento = :costomantenimiento"),
    @NamedQuery(name = "Mantenimiento.findByFechaentregado", query = "SELECT m FROM Mantenimiento m WHERE m.fechaentregado = :fechaentregado"),
    @NamedQuery(name = "Mantenimiento.findByFechaestimadarecepcion", query = "SELECT m FROM Mantenimiento m WHERE m.fechaestimadarecepcion = :fechaestimadarecepcion"),
    @NamedQuery(name = "Mantenimiento.findByFecharealrecepcion", query = "SELECT m FROM Mantenimiento m WHERE m.fecharealrecepcion = :fecharealrecepcion"),
    @NamedQuery(name = "Mantenimiento.findByEstadomantenimiento", query = "SELECT m FROM Mantenimiento m WHERE m.estadomantenimiento = :estadomantenimiento")})
public class Mantenimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmantenimiento")
    private Integer idmantenimiento;
    @Basic(optional = false)
    @Size(min = 1, max = 200)
    @Column(name = "dscmantenimiento")
    private String dscmantenimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "costomantenimiento")
    private BigDecimal costomantenimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaentregado")
    @Temporal(TemporalType.DATE)
    private Date fechaentregado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaestimadarecepcion")
    @Temporal(TemporalType.DATE)
    private Date fechaestimadarecepcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecharealrecepcion")
    @Temporal(TemporalType.DATE)
    private Date fecharealrecepcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadomantenimiento")
    private Character estadomantenimiento;
    @JoinTable(name = "proporciona", joinColumns = {
        @JoinColumn(name = "idmantenimiento", referencedColumnName = "idmantenimiento")}, inverseJoinColumns = {
        @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")})
    @ManyToMany
    private Collection<Persona> personaCollection;
    @JoinColumn(name = "idactivo", referencedColumnName = "idactivo")
    @ManyToOne
    private Activo idactivo;

    public Mantenimiento() {
    }

    public Mantenimiento(Integer idmantenimiento) {
        this.idmantenimiento = idmantenimiento;
    }

    public Mantenimiento(Integer idmantenimiento, String dscmantenimiento, BigDecimal costomantenimiento, Date fechaentregado, Date fechaestimadarecepcion, Date fecharealrecepcion, Character estadomantenimiento) {
        this.idmantenimiento = idmantenimiento;
        this.dscmantenimiento = dscmantenimiento;
        this.costomantenimiento = costomantenimiento;
        this.fechaentregado = fechaentregado;
        this.fechaestimadarecepcion = fechaestimadarecepcion;
        this.fecharealrecepcion = fecharealrecepcion;
        this.estadomantenimiento = estadomantenimiento;
    }

    public Integer getIdmantenimiento() {
        return idmantenimiento;
    }

    public void setIdmantenimiento(Integer idmantenimiento) {
        this.idmantenimiento = idmantenimiento;
    }

    public String getDscmantenimiento() {
        return dscmantenimiento;
    }

    public void setDscmantenimiento(String dscmantenimiento) {
        this.dscmantenimiento = dscmantenimiento;
    }

    public BigDecimal getCostomantenimiento() {
        return costomantenimiento;
    }

    public void setCostomantenimiento(BigDecimal costomantenimiento) {
        this.costomantenimiento = costomantenimiento;
    }

    public Date getFechaentregado() {
        return fechaentregado;
    }

    public void setFechaentregado(Date fechaentregado) {
        this.fechaentregado = fechaentregado;
    }

    public Date getFechaestimadarecepcion() {
        return fechaestimadarecepcion;
    }

    public void setFechaestimadarecepcion(Date fechaestimadarecepcion) {
        this.fechaestimadarecepcion = fechaestimadarecepcion;
    }

    public Date getFecharealrecepcion() {
        return fecharealrecepcion;
    }

    public void setFecharealrecepcion(Date fecharealrecepcion) {
        this.fecharealrecepcion = fecharealrecepcion;
    }

    public Character getEstadomantenimiento() {
        return estadomantenimiento;
    }

    public void setEstadomantenimiento(Character estadomantenimiento) {
        this.estadomantenimiento = estadomantenimiento;
    }

    @XmlTransient
    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }

    public Activo getIdactivo() {
        return idactivo;
    }

    public void setIdactivo(Activo idactivo) {
        this.idactivo = idactivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmantenimiento != null ? idmantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mantenimiento)) {
            return false;
        }
        Mantenimiento other = (Mantenimiento) object;
        if ((this.idmantenimiento == null && other.idmantenimiento != null) || (this.idmantenimiento != null && !this.idmantenimiento.equals(other.idmantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Mantenimiento[ idmantenimiento=" + idmantenimiento + " ]";
    }
    
}
