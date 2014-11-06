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
@Table(name = "ubicacionfisica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ubicacionfisica.findAll", query = "SELECT u FROM Ubicacionfisica u"),
    @NamedQuery(name = "Ubicacionfisica.findByIdubicacion", query = "SELECT u FROM Ubicacionfisica u WHERE u.idubicacion = :idubicacion"),
    @NamedQuery(name = "Ubicacionfisica.findByNmbubicacion", query = "SELECT u FROM Ubicacionfisica u WHERE u.nmbubicacion = :nmbubicacion"),
    @NamedQuery(name = "Ubicacionfisica.findByDirubicacion", query = "SELECT u FROM Ubicacionfisica u WHERE u.dirubicacion = :dirubicacion"),
    @NamedQuery(name = "Ubicacionfisica.findByTelefono", query = "SELECT u FROM Ubicacionfisica u WHERE u.telefono = :telefono"),
    @NamedQuery(name = "Ubicacionfisica.findByObsubicacion", query = "SELECT u FROM Ubicacionfisica u WHERE u.obsubicacion = :obsubicacion"),
    @NamedQuery(name = "Ubicacionfisica.findByEstadoubicacion", query = "SELECT u FROM Ubicacionfisica u WHERE u.estadoubicacion = :estadoubicacion")})
public class Ubicacionfisica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "idubicacion")
    private String idubicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nmbubicacion")
    private String nmbubicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "dirubicacion")
    private String dirubicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 200)
    @Column(name = "obsubicacion")
    private String obsubicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoubicacion")
    private Character estadoubicacion;
    @JoinColumn(name = "iddpto", referencedColumnName = "iddpto")
    @ManyToOne(optional = false)
    private Departamento iddpto;
    @JoinColumn(name = "idmunicipio", referencedColumnName = "idmunicipio")
    @ManyToOne(optional = false)
    private Municipio idmunicipio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idubicacion")
    private Collection<Activo> activoCollection;

    public Ubicacionfisica() {
    }

    public Ubicacionfisica(String idubicacion) {
        this.idubicacion = idubicacion;
    }

    public Ubicacionfisica(String idubicacion, String nmbubicacion, String dirubicacion, String telefono, Character estadoubicacion) {
        this.idubicacion = idubicacion;
        this.nmbubicacion = nmbubicacion;
        this.dirubicacion = dirubicacion;
        this.telefono = telefono;
        this.estadoubicacion = estadoubicacion;
    }

    public String getIdubicacion() {
        return idubicacion;
    }

    public void setIdubicacion(String idubicacion) {
        this.idubicacion = idubicacion;
    }

    public String getNmbubicacion() {
        return nmbubicacion;
    }

    public void setNmbubicacion(String nmbubicacion) {
        this.nmbubicacion = nmbubicacion;
    }

    public String getDirubicacion() {
        return dirubicacion;
    }

    public void setDirubicacion(String dirubicacion) {
        this.dirubicacion = dirubicacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getObsubicacion() {
        return obsubicacion;
    }

    public void setObsubicacion(String obsubicacion) {
        this.obsubicacion = obsubicacion;
    }

    public Character getEstadoubicacion() {
        return estadoubicacion;
    }

    public void setEstadoubicacion(Character estadoubicacion) {
        this.estadoubicacion = estadoubicacion;
    }

    public Departamento getIddpto() {
        return iddpto;
    }

    public void setIddpto(Departamento iddpto) {
        this.iddpto = iddpto;
    }

    public Municipio getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(Municipio idmunicipio) {
        this.idmunicipio = idmunicipio;
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
        hash += (idubicacion != null ? idubicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubicacionfisica)) {
            return false;
        }
        Ubicacionfisica other = (Ubicacionfisica) object;
        if ((this.idubicacion == null && other.idubicacion != null) || (this.idubicacion != null && !this.idubicacion.equals(other.idubicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nmbubicacion;
    }
    
}
