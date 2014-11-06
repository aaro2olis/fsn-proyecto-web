/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author FSN-Desarrollo
 */
@Entity
@Table(name = "tipodesafectacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipodesafectacion.findAll", query = "SELECT t FROM Tipodesafectacion t"),
    @NamedQuery(name = "Tipodesafectacion.findByIdtipodesafectacion", query = "SELECT t FROM Tipodesafectacion t WHERE t.idtipodesafectacion = :idtipodesafectacion"),
    @NamedQuery(name = "Tipodesafectacion.findByNmbdesafectacion", query = "SELECT t FROM Tipodesafectacion t WHERE t.nmbdesafectacion = :nmbdesafectacion"),
    @NamedQuery(name = "Tipodesafectacion.findByDscdesafectacion", query = "SELECT t FROM Tipodesafectacion t WHERE t.dscdesafectacion = :dscdesafectacion")})
public class Tipodesafectacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipodesafectacion")
    private Integer idtipodesafectacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nmbdesafectacion")
    private String nmbdesafectacion;
    @Size(max = 200)
    @Column(name = "dscdesafectacion")
    private String dscdesafectacion;
    @OneToMany(mappedBy = "idtipodesafectacion")
    private Collection<Desafectacion> desafectacionCollection;

    public Tipodesafectacion() {
    }

    public Tipodesafectacion(Integer idtipodesafectacion) {
        this.idtipodesafectacion = idtipodesafectacion;
    }

    public Tipodesafectacion(Integer idtipodesafectacion, String nmbdesafectacion) {
        this.idtipodesafectacion = idtipodesafectacion;
        this.nmbdesafectacion = nmbdesafectacion;
    }

    public Integer getIdtipodesafectacion() {
        return idtipodesafectacion;
    }

    public void setIdtipodesafectacion(Integer idtipodesafectacion) {
        this.idtipodesafectacion = idtipodesafectacion;
    }

    public String getNmbdesafectacion() {
        return nmbdesafectacion;
    }

    public void setNmbdesafectacion(String nmbdesafectacion) {
        this.nmbdesafectacion = nmbdesafectacion;
    }

    public String getDscdesafectacion() {
        return dscdesafectacion;
    }

    public void setDscdesafectacion(String dscdesafectacion) {
        this.dscdesafectacion = dscdesafectacion;
    }

    @XmlTransient
    public Collection<Desafectacion> getDesafectacionCollection() {
        return desafectacionCollection;
    }

    public void setDesafectacionCollection(Collection<Desafectacion> desafectacionCollection) {
        this.desafectacionCollection = desafectacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipodesafectacion != null ? idtipodesafectacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipodesafectacion)) {
            return false;
        }
        Tipodesafectacion other = (Tipodesafectacion) object;
        if ((this.idtipodesafectacion == null && other.idtipodesafectacion != null) || (this.idtipodesafectacion != null && !this.idtipodesafectacion.equals(other.idtipodesafectacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Tipodesafectacion[ idtipodesafectacion=" + idtipodesafectacion + " ]";
    }
    
}
