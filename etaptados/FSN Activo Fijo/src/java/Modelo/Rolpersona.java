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
@Table(name = "rolpersona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rolpersona.findAll", query = "SELECT r FROM Rolpersona r ORDER BY r.nmbrolpersona"),
    @NamedQuery(name = "Rolpersona.findByIdrolpersona", query = "SELECT r FROM Rolpersona r WHERE r.idrolpersona = :idrolpersona"),
    @NamedQuery(name = "Rolpersona.findByNmbrolpersona", query = "SELECT r FROM Rolpersona r WHERE r.nmbrolpersona = :nmbrolpersona"),
    @NamedQuery(name = "Rolpersona.findByDscrol", query = "SELECT r FROM Rolpersona r WHERE r.dscrol = :dscrol")})
public class Rolpersona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrolpersona")
    private Integer idrolpersona;
    @Size(max = 25)
    @Column(name = "nmbrolpersona")
    private String nmbrolpersona;
    @Size(max = 100)
    @Column(name = "dscrol_")
    private String dscrol;
    @OneToMany(mappedBy = "idrolpersona")
    private Collection<Persona> personaCollection;

    public Rolpersona() {
    }

    public Rolpersona(Integer idrolpersona) {
        this.idrolpersona = idrolpersona;
    }

    public Integer getIdrolpersona() {
        return idrolpersona;
    }

    public void setIdrolpersona(Integer idrolpersona) {
        this.idrolpersona = idrolpersona;
    }

    public String getNmbrolpersona() {
        return nmbrolpersona;
    }

    public void setNmbrolpersona(String nmbrolpersona) {
        this.nmbrolpersona = nmbrolpersona;
    }

    public String getDscrol() {
        return dscrol;
    }

    public void setDscrol(String dscrol) {
        this.dscrol = dscrol;
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
        hash += (idrolpersona != null ? idrolpersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rolpersona)) {
            return false;
        }
        Rolpersona other = (Rolpersona) object;
        if ((this.idrolpersona == null && other.idrolpersona != null) || (this.idrolpersona != null && !this.idrolpersona.equals(other.idrolpersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nmbrolpersona;
    }
    
}
