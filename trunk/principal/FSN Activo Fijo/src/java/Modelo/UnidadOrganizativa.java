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
@Table(name = "unidad_organizativa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadOrganizativa.findAll", query = "SELECT u FROM UnidadOrganizativa u"),
    @NamedQuery(name = "UnidadOrganizativa.findByIdunidad", query = "SELECT u FROM UnidadOrganizativa u WHERE u.idunidad = :idunidad"),
    @NamedQuery(name = "UnidadOrganizativa.findByNmbunidad", query = "SELECT u FROM UnidadOrganizativa u WHERE u.nmbunidad = :nmbunidad"),
    @NamedQuery(name = "UnidadOrganizativa.findByDscunidad", query = "SELECT u FROM UnidadOrganizativa u WHERE u.dscunidad = :dscunidad"),
    @NamedQuery(name = "UnidadOrganizativa.findByEstadounidad", query = "SELECT u FROM UnidadOrganizativa u WHERE u.estadounidad = :estadounidad")})
public class UnidadOrganizativa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idunidad")
    private Integer idunidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nmbunidad")
    private String nmbunidad;
    @Size(max = 100)
    @Column(name = "dscunidad")
    private String dscunidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadounidad")
    private Character estadounidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idunidad")
    private Collection<Empleado> empleadoCollection;
    @OneToMany(mappedBy = "uniIdunidad")
    private Collection<UnidadOrganizativa> unidadOrganizativaCollection;
    @JoinColumn(name = "uni_idunidad", referencedColumnName = "idunidad")
    @ManyToOne
    private UnidadOrganizativa uniIdunidad;

    public UnidadOrganizativa() {
  
    }

    public UnidadOrganizativa(Integer idunidad) {
        this.idunidad = idunidad;
    }

    public UnidadOrganizativa(Integer idunidad, String nmbunidad, Character estadounidad) {
        this.idunidad = idunidad;
        this.nmbunidad = nmbunidad;
        this.estadounidad = estadounidad;
    }

    public Integer getIdunidad() {
        return idunidad;
    }

    public void setIdunidad(Integer idunidad) {
        this.idunidad = idunidad;
    }

    public String getNmbunidad() {
        return nmbunidad;
    }

    public void setNmbunidad(String nmbunidad) {
        this.nmbunidad = nmbunidad;
    }

    public String getDscunidad() {
        return dscunidad;
    }

    public void setDscunidad(String dscunidad) {
        this.dscunidad = dscunidad;
    }

    public Character getEstadounidad() {
        return estadounidad;
    }
    
 
    public void setEstadounidad(Character estadounidad) {
        this.estadounidad = estadounidad;
    }
 public void setEstadounidad() {
        this.estadounidad = '1';
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }

    @XmlTransient
    public Collection<UnidadOrganizativa> getUnidadOrganizativaCollection() {
        return unidadOrganizativaCollection;
    }

    public void setUnidadOrganizativaCollection(Collection<UnidadOrganizativa> unidadOrganizativaCollection) {
        this.unidadOrganizativaCollection = unidadOrganizativaCollection;
    }

    public UnidadOrganizativa getUniIdunidad() {
        return uniIdunidad;
    }

    public void setUniIdunidad(UnidadOrganizativa uniIdunidad) {
        this.uniIdunidad = uniIdunidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idunidad != null ? idunidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadOrganizativa)) {
            return false;
        }
        UnidadOrganizativa other = (UnidadOrganizativa) object;
        if ((this.idunidad == null && other.idunidad != null) || (this.idunidad != null && !this.idunidad.equals(other.idunidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idunidad+".- "+nmbunidad;
    }
    
}
