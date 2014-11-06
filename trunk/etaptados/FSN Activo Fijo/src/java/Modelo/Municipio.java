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
@Table(name = "municipio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m"),
    @NamedQuery(name = "Municipio.findByIdmunicipio", query = "SELECT m FROM Municipio m WHERE m.idmunicipio = :idmunicipio"),
    @NamedQuery(name = "Municipio.findByNmbmunicipio", query = "SELECT m FROM Municipio m WHERE m.nmbmunicipio = :nmbmunicipio")})
public class Municipio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmunicipio")
    private Integer idmunicipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nmbmunicipio")
    private String nmbmunicipio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmunicipio")
    private Collection<Ubicacionfisica> ubicacionfisicaCollection;
    @JoinColumn(name = "iddpto", referencedColumnName = "iddpto")
    @ManyToOne(optional = false)
    private Departamento iddpto;

    public Municipio() {
    }

    public Municipio(Integer idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public Municipio(Integer idmunicipio, String nmbmunicipio) {
        this.idmunicipio = idmunicipio;
        this.nmbmunicipio = nmbmunicipio;
    }

    public Integer getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(Integer idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getNmbmunicipio() {
        return nmbmunicipio;
    }

    public void setNmbmunicipio(String nmbmunicipio) {
        this.nmbmunicipio = nmbmunicipio;
    }

    @XmlTransient
    public Collection<Ubicacionfisica> getUbicacionfisicaCollection() {
        return ubicacionfisicaCollection;
    }

    public void setUbicacionfisicaCollection(Collection<Ubicacionfisica> ubicacionfisicaCollection) {
        this.ubicacionfisicaCollection = ubicacionfisicaCollection;
    }

    public Departamento getIddpto() {
        return iddpto;
    }

    public void setIddpto(Departamento iddpto) {
        this.iddpto = iddpto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmunicipio != null ? idmunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.idmunicipio == null && other.idmunicipio != null) || (this.idmunicipio != null && !this.idmunicipio.equals(other.idmunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nmbmunicipio;
    }
    
}
