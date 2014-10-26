/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "tipoestado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoestado.findAll", query = "SELECT t FROM Tipoestado t"),
    @NamedQuery(name = "Tipoestado.findByIdtipoestado", query = "SELECT t FROM Tipoestado t WHERE t.idtipoestado = :idtipoestado"),
    @NamedQuery(name = "Tipoestado.findByNmbtipoestado", query = "SELECT t FROM Tipoestado t WHERE t.nmbtipoestado = :nmbtipoestado"),
    @NamedQuery(name = "Tipoestado.findByDsctipoestado", query = "SELECT t FROM Tipoestado t WHERE t.dsctipoestado = :dsctipoestado")})
public class Tipoestado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipoestado")
    private Integer idtipoestado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nmbtipoestado")
    private String nmbtipoestado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "dsctipoestado")
    private String dsctipoestado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoestado")
    private Collection<Activo> activoCollection;

    public Tipoestado() {
    }

    public Tipoestado(Integer idtipoestado) {
        this.idtipoestado = idtipoestado;
    }

    public Tipoestado(Integer idtipoestado, String nmbtipoestado, String dsctipoestado) {
        this.idtipoestado = idtipoestado;
        this.nmbtipoestado = nmbtipoestado;
        this.dsctipoestado = dsctipoestado;
    }

    public Integer getIdtipoestado() {
        return idtipoestado;
    }

    public void setIdtipoestado(Integer idtipoestado) {
        this.idtipoestado = idtipoestado;
    }

    public String getNmbtipoestado() {
        return nmbtipoestado;
    }

    public void setNmbtipoestado(String nmbtipoestado) {
        this.nmbtipoestado = nmbtipoestado;
    }

    public String getDsctipoestado() {
        return dsctipoestado;
    }

    public void setDsctipoestado(String dsctipoestado) {
        this.dsctipoestado = dsctipoestado;
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
        hash += (idtipoestado != null ? idtipoestado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoestado)) {
            return false;
        }
        Tipoestado other = (Tipoestado) object;
        if ((this.idtipoestado == null && other.idtipoestado != null) || (this.idtipoestado != null && !this.idtipoestado.equals(other.idtipoestado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Tipoestado[ idtipoestado=" + idtipoestado + " ]";
    }
    
}
