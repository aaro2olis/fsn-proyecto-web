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
 * @author FSN-Desarrollo
 */
@Entity
@Table(name = "detallecategoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallecategoria.findAll", query = "SELECT d FROM Detallecategoria d"),
    @NamedQuery(name = "Detallecategoria.findByIddetallecategoria", query = "SELECT d FROM Detallecategoria d WHERE d.iddetallecategoria = :iddetallecategoria"),
    @NamedQuery(name = "Detallecategoria.findByDscdetalle", query = "SELECT d FROM Detallecategoria d WHERE d.dscdetalle = :dscdetalle")})
public class Detallecategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetallecategoria")
    private Integer iddetallecategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "dscdetalle")
    private String dscdetalle;
    @OneToMany(mappedBy = "iddetallecategoria")
    private Collection<Especificacionactivo> especificacionactivoCollection;
    @JoinColumn(name = "idcategoria", referencedColumnName = "idcategoria")
    @ManyToOne(optional = false)
    private Categoria idcategoria;

    public Detallecategoria() {
    }

    public Detallecategoria(Integer iddetallecategoria) {
        this.iddetallecategoria = iddetallecategoria;
    }

    public Detallecategoria(Integer iddetallecategoria, String dscdetalle) {
        this.iddetallecategoria = iddetallecategoria;
        this.dscdetalle = dscdetalle;
    }

    public Integer getIddetallecategoria() {
        return iddetallecategoria;
    }

    public void setIddetallecategoria(Integer iddetallecategoria) {
        this.iddetallecategoria = iddetallecategoria;
    }

    public String getDscdetalle() {
        return dscdetalle;
    }

    public void setDscdetalle(String dscdetalle) {
        this.dscdetalle = dscdetalle;
    }

    @XmlTransient
    public Collection<Especificacionactivo> getEspecificacionactivoCollection() {
        return especificacionactivoCollection;
    }

    public void setEspecificacionactivoCollection(Collection<Especificacionactivo> especificacionactivoCollection) {
        this.especificacionactivoCollection = especificacionactivoCollection;
    }

    public Categoria getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Categoria idcategoria) {
        this.idcategoria = idcategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetallecategoria != null ? iddetallecategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallecategoria)) {
            return false;
        }
        Detallecategoria other = (Detallecategoria) object;
        if ((this.iddetallecategoria == null && other.iddetallecategoria != null) || (this.iddetallecategoria != null && !this.iddetallecategoria.equals(other.iddetallecategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Detallecategoria[ iddetallecategoria=" + iddetallecategoria + " ]";
    }
    
}
