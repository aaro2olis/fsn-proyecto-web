/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FSN-Desarrollo
 */
@Entity
@Table(name = "actividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a"),
    @NamedQuery(name = "Actividad.findByIdactivdad", query = "SELECT a FROM Actividad a WHERE a.idactivdad = :idactivdad"),
    @NamedQuery(name = "Actividad.findByEstadoactividad", query = "SELECT a FROM Actividad a WHERE a.estadoactividad = :estadoactividad")})
public class Actividad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idactivdad")
    private Integer idactivdad;
    @Column(name = "estadoactividad")
    private Character estadoactividad;
    @JoinColumn(name = "idplantilla", referencedColumnName = "idplantilla")
    @ManyToOne(optional = false)
    private Plantillaactividad idplantilla;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public Actividad() {
    }

    public Actividad(Integer idactivdad) {
        this.idactivdad = idactivdad;
    }

    public Integer getIdactivdad() {
        return idactivdad;
    }

    public void setIdactivdad(Integer idactivdad) {
        this.idactivdad = idactivdad;
    }

    public Character getEstadoactividad() {
        return estadoactividad;
    }

    public void setEstadoactividad(Character estadoactividad) {
        this.estadoactividad = estadoactividad;
    }

    public Plantillaactividad getIdplantilla() {
        return idplantilla;
    }

    public void setIdplantilla(Plantillaactividad idplantilla) {
        this.idplantilla = idplantilla;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idactivdad != null ? idactivdad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.idactivdad == null && other.idactivdad != null) || (this.idactivdad != null && !this.idactivdad.equals(other.idactivdad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Actividad[ idactivdad=" + idactivdad + " ]";
    }
    
}
