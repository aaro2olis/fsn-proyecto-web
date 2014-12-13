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
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
    @NamedQuery(name = "Categoria.findByIdcategoria", query = "SELECT c FROM Categoria c WHERE c.idcategoria = :idcategoria"),
    @NamedQuery(name = "Categoria.findByNmbcategoria", query = "SELECT c FROM Categoria c WHERE c.nmbcategoria = :nmbcategoria"),
    @NamedQuery(name = "Categoria.findByDsccategoria", query = "SELECT c FROM Categoria c WHERE c.dsccategoria = :dsccategoria")})
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "idcategoria")
    private String idcategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nmbcategoria")
    private String nmbcategoria;
    @Basic(optional = false)
    @Size(min = 1, max = 250)
    @Column(name = "dsccategoria")
    private String dsccategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcategoria")
    private Collection<Detallecategoria> detallecategoriaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcategoria")
    private Collection<Activo> activoCollection;

    public Categoria() {
    }

    public Categoria(String idcategoria) {
        this.idcategoria = idcategoria;
    }

    public Categoria(String idcategoria, String nmbcategoria, String dsccategoria) {
        this.idcategoria = idcategoria;
        this.nmbcategoria = nmbcategoria;
        this.dsccategoria = dsccategoria;
    }

    public String getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(String idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNmbcategoria() {
        return nmbcategoria;
    }

    public void setNmbcategoria(String nmbcategoria) {
        this.nmbcategoria = nmbcategoria;
    }

    public String getDsccategoria() {
        return dsccategoria;
    }

    public void setDsccategoria(String dsccategoria) {
        this.dsccategoria = dsccategoria;
    }

    @XmlTransient
    public Collection<Detallecategoria> getDetallecategoriaCollection() {
        return detallecategoriaCollection;
    }

    public void setDetallecategoriaCollection(Collection<Detallecategoria> detallecategoriaCollection) {
        this.detallecategoriaCollection = detallecategoriaCollection;
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
        hash += (idcategoria != null ? idcategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.idcategoria == null && other.idcategoria != null) || (this.idcategoria != null && !this.idcategoria.equals(other.idcategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nmbcategoria;
    }
      public String genCodCategoria(Integer cuenta)
     {String carnet;
      cuenta=cuenta+1;
         if (cuenta<10) {
         carnet="C-0"+cuenta.toString();
         }
         else {
             if (cuenta<100) {
             carnet="C-"+cuenta.toString();    
             }
             else{
             carnet="C-"+cuenta.toString();
             }
         }
    return carnet;
             }
  
}
