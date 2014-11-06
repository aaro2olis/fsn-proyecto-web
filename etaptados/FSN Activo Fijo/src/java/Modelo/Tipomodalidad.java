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
@Table(name = "tipomodalidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipomodalidad.findAll", query = "SELECT t FROM Tipomodalidad t"),
    @NamedQuery(name = "Tipomodalidad.findByIdmodalidad", query = "SELECT t FROM Tipomodalidad t WHERE t.idmodalidad = :idmodalidad"),
    @NamedQuery(name = "Tipomodalidad.findByNmbmodalidad", query = "SELECT t FROM Tipomodalidad t WHERE t.nmbmodalidad = :nmbmodalidad"),
    @NamedQuery(name = "Tipomodalidad.findByDscmodalidad", query = "SELECT t FROM Tipomodalidad t WHERE t.dscmodalidad = :dscmodalidad")})
public class Tipomodalidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmodalidad")
    private Integer idmodalidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nmbmodalidad")
    private String nmbmodalidad;
    @Size(max = 200)
    @Column(name = "dscmodalidad")
    private String dscmodalidad;
    @OneToMany(mappedBy = "idmodalidad")
    private Collection<Activo> activoCollection;

    public Tipomodalidad() {
    }

    public Tipomodalidad(Integer idmodalidad) {
        this.idmodalidad = idmodalidad;
    }

    public Tipomodalidad(Integer idmodalidad, String nmbmodalidad) {
        this.idmodalidad = idmodalidad;
        this.nmbmodalidad = nmbmodalidad;
    }

    public Integer getIdmodalidad() {
        return idmodalidad;
    }

    public void setIdmodalidad(Integer idmodalidad) {
        this.idmodalidad = idmodalidad;
    }

    public String getNmbmodalidad() {
        return nmbmodalidad;
    }

    public void setNmbmodalidad(String nmbmodalidad) {
        this.nmbmodalidad = nmbmodalidad;
    }

    public String getDscmodalidad() {
        return dscmodalidad;
    }

    public void setDscmodalidad(String dscmodalidad) {
        this.dscmodalidad = dscmodalidad;
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
        hash += (idmodalidad != null ? idmodalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipomodalidad)) {
            return false;
        }
        Tipomodalidad other = (Tipomodalidad) object;
        if ((this.idmodalidad == null && other.idmodalidad != null) || (this.idmodalidad != null && !this.idmodalidad.equals(other.idmodalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nmbmodalidad;
    }
    
}
