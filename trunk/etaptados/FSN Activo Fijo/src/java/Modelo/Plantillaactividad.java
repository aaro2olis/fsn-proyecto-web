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
@Table(name = "plantillaactividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plantillaactividad.findAll", query = "SELECT p FROM Plantillaactividad p"),
    @NamedQuery(name = "Plantillaactividad.findByIdplantilla", query = "SELECT p FROM Plantillaactividad p WHERE p.idplantilla = :idplantilla"),
    @NamedQuery(name = "Plantillaactividad.findByDscplantilla", query = "SELECT p FROM Plantillaactividad p WHERE p.dscplantilla = :dscplantilla"),
    @NamedQuery(name = "Plantillaactividad.findByEstadoplantilla", query = "SELECT p FROM Plantillaactividad p WHERE p.estadoplantilla = :estadoplantilla")})
public class Plantillaactividad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idplantilla")
    private Integer idplantilla;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "dscplantilla")
    private String dscplantilla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoplantilla")
    private Character estadoplantilla;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idplantilla")
    private Collection<Actividad> actividadCollection;
    @JoinColumn(name = "idrol", referencedColumnName = "idrol")
    @ManyToOne(optional = false)
    private Rol idrol;

    public Plantillaactividad() {
    }

    public Plantillaactividad(Integer idplantilla) {
        this.idplantilla = idplantilla;
    }

    public Plantillaactividad(Integer idplantilla, String dscplantilla, Character estadoplantilla) {
        this.idplantilla = idplantilla;
        this.dscplantilla = dscplantilla;
        this.estadoplantilla = estadoplantilla;
    }

    public Integer getIdplantilla() {
        return idplantilla;
    }

    public void setIdplantilla(Integer idplantilla) {
        this.idplantilla = idplantilla;
    }

    public String getDscplantilla() {
        return dscplantilla;
    }

    public void setDscplantilla(String dscplantilla) {
        this.dscplantilla = dscplantilla;
    }

    public Character getEstadoplantilla() {
        return estadoplantilla;
    }

    public void setEstadoplantilla(Character estadoplantilla) {
        this.estadoplantilla = estadoplantilla;
    }

    @XmlTransient
    public Collection<Actividad> getActividadCollection() {
        return actividadCollection;
    }

    public void setActividadCollection(Collection<Actividad> actividadCollection) {
        this.actividadCollection = actividadCollection;
    }

    public Rol getIdrol() {
        return idrol;
    }

    public void setIdrol(Rol idrol) {
        this.idrol = idrol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplantilla != null ? idplantilla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plantillaactividad)) {
            return false;
        }
        Plantillaactividad other = (Plantillaactividad) object;
        if ((this.idplantilla == null && other.idplantilla != null) || (this.idplantilla != null && !this.idplantilla.equals(other.idplantilla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Plantillaactividad[ idplantilla=" + idplantilla + " ]";
    }
    
}
