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
@Table(name = "departamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d ORDER BY d.nmbdpto"),
    @NamedQuery(name = "Departamento.findByIddpto", query = "SELECT d FROM Departamento d WHERE d.iddpto = :iddpto"),
    @NamedQuery(name = "Departamento.findByNmbdpto", query = "SELECT d FROM Departamento d WHERE d.nmbdpto = :nmbdpto"),
    @NamedQuery(name = "Departamento.findByObsdpto", query = "SELECT d FROM Departamento d WHERE d.obsdpto = :obsdpto")})
public class Departamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddpto")
    private Integer iddpto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nmbdpto")
    private String nmbdpto;
    @Basic(optional = false)
    @Size(min = 1, max = 200)
    @Column(name = "obsdpto")
    private String obsdpto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddpto")
    private Collection<Ubicacionfisica> ubicacionfisicaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddpto")
    private Collection<Municipio> municipioCollection;

    public Departamento() {
    }

    public Departamento(Integer iddpto) {
        this.iddpto = iddpto;
    }

    public Departamento(Integer iddpto, String nmbdpto, String obsdpto) {
        this.iddpto = iddpto;
        this.nmbdpto = nmbdpto;
        this.obsdpto = obsdpto;
    }

    public Integer getIddpto() {
        return iddpto;
    }

    public void setIddpto(Integer iddpto) {
        this.iddpto = iddpto;
    }

    public String getNmbdpto() {
        return nmbdpto;
    }

    public void setNmbdpto(String nmbdpto) {
        this.nmbdpto = nmbdpto;
    }

    public String getObsdpto() {
        return obsdpto;
    }

    public void setObsdpto(String obsdpto) {
        this.obsdpto = obsdpto;
    }

    @XmlTransient
    public Collection<Ubicacionfisica> getUbicacionfisicaCollection() {
        return ubicacionfisicaCollection;
    }

    public void setUbicacionfisicaCollection(Collection<Ubicacionfisica> ubicacionfisicaCollection) {
        this.ubicacionfisicaCollection = ubicacionfisicaCollection;
    }

    @XmlTransient
    public Collection<Municipio> getMunicipioCollection() {
        return municipioCollection;
    }

    public void setMunicipioCollection(Collection<Municipio> municipioCollection) {
        this.municipioCollection = municipioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddpto != null ? iddpto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.iddpto == null && other.iddpto != null) || (this.iddpto != null && !this.iddpto.equals(other.iddpto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nmbdpto;
    }
    
}
