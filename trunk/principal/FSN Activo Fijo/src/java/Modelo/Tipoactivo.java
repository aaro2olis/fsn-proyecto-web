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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FSN-Desarrollo
 */
@Entity
@Table(name = "tipoactivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoactivo.findAll", query = "SELECT t FROM Tipoactivo t"),
    @NamedQuery(name = "Tipoactivo.findByIdtipoactivo", query = "SELECT t FROM Tipoactivo t WHERE t.idtipoactivo = :idtipoactivo"),
    @NamedQuery(name = "Tipoactivo.findByNmbactivo", query = "SELECT t FROM Tipoactivo t WHERE t.nmbactivo = :nmbactivo"),
    @NamedQuery(name = "Tipoactivo.findByVidautil", query = "SELECT t FROM Tipoactivo t WHERE t.vidautil = :vidautil")})
public class Tipoactivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipoactivo")
    private Integer idtipoactivo;
    @Size(max = 25)
    @Column(name = "nmbactivo")
    private String nmbactivo;
    @Column(name = "vidautil")
    private Integer vidautil;
    @OneToMany(mappedBy = "idtipoactivo")
    private Collection<Activo> activoCollection;

    public Tipoactivo() {
    }

    public Tipoactivo(Integer idtipoactivo) {
        this.idtipoactivo = idtipoactivo;
    }

    public Integer getIdtipoactivo() {
        return idtipoactivo;
    }

    public void setIdtipoactivo(Integer idtipoactivo) {
        this.idtipoactivo = idtipoactivo;
    }

    public String getNmbactivo() {
        return nmbactivo;
    }

    public void setNmbactivo(String nmbactivo) {
        this.nmbactivo = nmbactivo;
    }

    public Integer getVidautil() {
        return vidautil;
    }

    public void setVidautil(Integer vidautil) {
        this.vidautil = vidautil;
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
        hash += (idtipoactivo != null ? idtipoactivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoactivo)) {
            return false;
        }
        Tipoactivo other = (Tipoactivo) object;
        if ((this.idtipoactivo == null && other.idtipoactivo != null) || (this.idtipoactivo != null && !this.idtipoactivo.equals(other.idtipoactivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Tipoactivo[ idtipoactivo=" + idtipoactivo + " ]";
    }
    
}
