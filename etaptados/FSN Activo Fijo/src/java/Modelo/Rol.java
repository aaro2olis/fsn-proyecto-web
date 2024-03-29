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
@Table(name = "rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r ORDER BY r.nmbtipousuario"),
    @NamedQuery(name = "Rol.findByIdrol", query = "SELECT r FROM Rol r WHERE r.idrol = :idrol"),
    @NamedQuery(name = "Rol.findByNmbtipousuario", query = "SELECT r FROM Rol r WHERE r.nmbtipousuario = :nmbtipousuario"),
    @NamedQuery(name = "Rol.findByDsctipousuario", query = "SELECT r FROM Rol r WHERE r.dsctipousuario = :dsctipousuario")})
public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrol")
    private Integer idrol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nmbtipousuario")
    private String nmbtipousuario;
    @Size(max = 100)
    @Column(name = "dsctipousuario")
    private String dsctipousuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrol")
    private Collection<Plantillaactividad> plantillaactividadCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrol")
    private Collection<Usuario> usuarioCollection;

    public Rol() {
    }

    public Rol(Integer idrol) {
        this.idrol = idrol;
    }

    public Rol(Integer idrol, String nmbtipousuario) {
        this.idrol = idrol;
        this.nmbtipousuario = nmbtipousuario;
    }

    public Integer getIdrol() {
        return idrol;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }

    public String getNmbtipousuario() {
        return nmbtipousuario;
    }

    public void setNmbtipousuario(String nmbtipousuario) {
        this.nmbtipousuario = nmbtipousuario;
    }

    public String getDsctipousuario() {
        return dsctipousuario;
    }

    public void setDsctipousuario(String dsctipousuario) {
        this.dsctipousuario = dsctipousuario;
    }

    @XmlTransient
    public Collection<Plantillaactividad> getPlantillaactividadCollection() {
        return plantillaactividadCollection;
    }

    public void setPlantillaactividadCollection(Collection<Plantillaactividad> plantillaactividadCollection) {
        this.plantillaactividadCollection = plantillaactividadCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrol != null ? idrol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.idrol == null && other.idrol != null) || (this.idrol != null && !this.idrol.equals(other.idrol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nmbtipousuario;
    }
    
}
