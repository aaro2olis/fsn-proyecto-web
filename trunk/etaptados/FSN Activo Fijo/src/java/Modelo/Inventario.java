/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FSN-Desarrollo
 */
@Entity
@Table(name = "inventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i"),
    @NamedQuery(name = "Inventario.findByIdinventario", query = "SELECT i FROM Inventario i WHERE i.idinventario = :idinventario"),
    @NamedQuery(name = "Inventario.findByFecharealizacion", query = "SELECT i FROM Inventario i WHERE i.fecharealizacion = :fecharealizacion"),
    @NamedQuery(name = "Inventario.findByHorarealizacion", query = "SELECT i FROM Inventario i WHERE i.horarealizacion = :horarealizacion"),
    @NamedQuery(name = "Inventario.findByEstadobienactual", query = "SELECT i FROM Inventario i WHERE i.estadobienactual = :estadobienactual"),
    @NamedQuery(name = "Inventario.findByObservacion", query = "SELECT i FROM Inventario i WHERE i.observacion = :observacion"),
    @NamedQuery(name = "Inventario.findByPoseevineta", query = "SELECT i FROM Inventario i WHERE i.poseevineta = :poseevineta"),
    @NamedQuery(name = "Inventario.findByExiste", query = "SELECT i FROM Inventario i WHERE i.existe = :existe"),
    @NamedQuery(name = "Inventario.findByBajocustodia", query = "SELECT i FROM Inventario i WHERE i.bajocustodia = :bajocustodia"),
    @NamedQuery(name = "Inventario.findByUbicacionfisica", query = "SELECT i FROM Inventario i WHERE i.ubicacionfisica = :ubicacionfisica"),
    @NamedQuery(name = "Inventario.findByJustificaciondiferencias", query = "SELECT i FROM Inventario i WHERE i.justificaciondiferencias = :justificaciondiferencias"),
    @NamedQuery(name = "Inventario.findByFechajustificacion", query = "SELECT i FROM Inventario i WHERE i.fechajustificacion = :fechajustificacion")})
public class Inventario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinventario")
    private Integer idinventario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecharealizacion")
    @Temporal(TemporalType.DATE)
    private Date fecharealizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horarealizacion")
    @Temporal(TemporalType.TIME)
    private Date horarealizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadobienactual")
    private Character estadobienactual;
    @Size(max = 200)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "poseevineta")
    private Character poseevineta;
    @Column(name = "existe")
    private Character existe;
    @Column(name = "bajocustodia")
    private Character bajocustodia;
    @Column(name = "ubicacionfisica")
    private Character ubicacionfisica;
    @Size(max = 200)
    @Column(name = "justificaciondiferencias")
    private String justificaciondiferencias;
    @Column(name = "fechajustificacion")
    @Temporal(TemporalType.DATE)
    private Date fechajustificacion;
    @JoinColumn(name = "idactivo", referencedColumnName = "idactivo")
    @ManyToOne(optional = false)
    private Activo idactivo;
    @JoinColumn(name = "emp_idempleado", referencedColumnName = "idempleado")
    @ManyToOne
    private Empleado empIdempleado;
    @JoinColumn(name = "idempleado", referencedColumnName = "idempleado")
    @ManyToOne(optional = false)
    private Empleado idempleado;

    public Inventario() {
    }

    public Inventario(Integer idinventario) {
        this.idinventario = idinventario;
    }

    public Inventario(Integer idinventario, Date fecharealizacion, Date horarealizacion, Character estadobienactual) {
        this.idinventario = idinventario;
        this.fecharealizacion = fecharealizacion;
        this.horarealizacion = horarealizacion;
        this.estadobienactual = estadobienactual;
    }

    public Integer getIdinventario() {
        return idinventario;
    }

    public void setIdinventario(Integer idinventario) {
        this.idinventario = idinventario;
    }

    public Date getFecharealizacion() {
        return fecharealizacion;
    }

    public void setFecharealizacion(Date fecharealizacion) {
        this.fecharealizacion = fecharealizacion;
    }

    public Date getHorarealizacion() {
        return horarealizacion;
    }

    public void setHorarealizacion(Date horarealizacion) {
        this.horarealizacion = horarealizacion;
    }

    public Character getEstadobienactual() {
        return estadobienactual;
    }

    public void setEstadobienactual(Character estadobienactual) {
        this.estadobienactual = estadobienactual;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Character getPoseevineta() {
        return poseevineta;
    }

    public void setPoseevineta(Character poseevineta) {
        this.poseevineta = poseevineta;
    }

    public Character getExiste() {
        return existe;
    }

    public void setExiste(Character existe) {
        this.existe = existe;
    }

    public Character getBajocustodia() {
        return bajocustodia;
    }

    public void setBajocustodia(Character bajocustodia) {
        this.bajocustodia = bajocustodia;
    }

    public Character getUbicacionfisica() {
        return ubicacionfisica;
    }

    public void setUbicacionfisica(Character ubicacionfisica) {
        this.ubicacionfisica = ubicacionfisica;
    }

    public String getJustificaciondiferencias() {
        return justificaciondiferencias;
    }

    public void setJustificaciondiferencias(String justificaciondiferencias) {
        this.justificaciondiferencias = justificaciondiferencias;
    }

    public Date getFechajustificacion() {
        return fechajustificacion;
    }

    public void setFechajustificacion(Date fechajustificacion) {
        this.fechajustificacion = fechajustificacion;
    }

    public Activo getIdactivo() {
        return idactivo;
    }

    public void setIdactivo(Activo idactivo) {
        this.idactivo = idactivo;
    }

    public Empleado getEmpIdempleado() {
        return empIdempleado;
    }

    public void setEmpIdempleado(Empleado empIdempleado) {
        this.empIdempleado = empIdempleado;
    }

    public Empleado getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Empleado idempleado) {
        this.idempleado = idempleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinventario != null ? idinventario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.idinventario == null && other.idinventario != null) || (this.idinventario != null && !this.idinventario.equals(other.idinventario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Inventario[ idinventario=" + idinventario + " ]";
    }
    
}
