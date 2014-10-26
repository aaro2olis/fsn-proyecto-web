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
@Table(name = "tipopersona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipopersona.findAll", query = "SELECT t FROM Tipopersona t"),
    @NamedQuery(name = "Tipopersona.findByIdtipopersona", query = "SELECT t FROM Tipopersona t WHERE t.idtipopersona = :idtipopersona"),
    @NamedQuery(name = "Tipopersona.findByNmbtipopersona", query = "SELECT t FROM Tipopersona t WHERE t.nmbtipopersona = :nmbtipopersona"),
    @NamedQuery(name = "Tipopersona.findByDsctipopersona", query = "SELECT t FROM Tipopersona t WHERE t.dsctipopersona = :dsctipopersona")})
public class Tipopersona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipopersona")
    private Integer idtipopersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nmbtipopersona")
    private String nmbtipopersona;
    @Size(max = 50)
    @Column(name = "dsctipopersona")
    private String dsctipopersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipopersona")
    private Collection<Persona> personaCollection;

    public Tipopersona() {
    }

    public Tipopersona(Integer idtipopersona) {
        this.idtipopersona = idtipopersona;
    }

    public Tipopersona(Integer idtipopersona, String nmbtipopersona) {
        this.idtipopersona = idtipopersona;
        this.nmbtipopersona = nmbtipopersona;
    }

    public Integer getIdtipopersona() {
        return idtipopersona;
    }

    public void setIdtipopersona(Integer idtipopersona) {
        this.idtipopersona = idtipopersona;
    }

    public String getNmbtipopersona() {
        return nmbtipopersona;
    }

    public void setNmbtipopersona(String nmbtipopersona) {
        this.nmbtipopersona = nmbtipopersona;
    }

    public String getDsctipopersona() {
        return dsctipopersona;
    }

    public void setDsctipopersona(String dsctipopersona) {
        this.dsctipopersona = dsctipopersona;
    }

    @XmlTransient
    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipopersona != null ? idtipopersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipopersona)) {
            return false;
        }
        Tipopersona other = (Tipopersona) object;
        if ((this.idtipopersona == null && other.idtipopersona != null) || (this.idtipopersona != null && !this.idtipopersona.equals(other.idtipopersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Tipopersona[ idtipopersona=" + idtipopersona + " ]";
    }
    
}
