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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FSN-Desarrollo
 */
@Entity
@Table(name = "especificacionactivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especificacionactivo.findAll", query = "SELECT e FROM Especificacionactivo e"),
    @NamedQuery(name = "Especificacionactivo.findByIdespecificacion", query = "SELECT e FROM Especificacionactivo e WHERE e.idespecificacion = :idespecificacion"),
    @NamedQuery(name = "Especificacionactivo.findByValor", query = "SELECT e FROM Especificacionactivo e WHERE e.valor = :valor")})
public class Especificacionactivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idespecificacion")
    private Integer idespecificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "valor")
    private String valor;
    @JoinColumn(name = "idactivo", referencedColumnName = "idactivo")
    @ManyToOne
    private Activo idactivo;
    @JoinColumn(name = "iddetallecategoria", referencedColumnName = "iddetallecategoria")
    @ManyToOne
    private Detallecategoria iddetallecategoria;

    public Especificacionactivo() {
    }

    public Especificacionactivo(Integer idespecificacion) {
        this.idespecificacion = idespecificacion;
    }

    public Especificacionactivo(Integer idespecificacion, String valor) {
        this.idespecificacion = idespecificacion;
        this.valor = valor;
    }

    public Integer getIdespecificacion() {
        return idespecificacion;
    }

    public void setIdespecificacion(Integer idespecificacion) {
        this.idespecificacion = idespecificacion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Activo getIdactivo() {
        return idactivo;
    }

    public void setIdactivo(Activo idactivo) {
        this.idactivo = idactivo;
    }

    public Detallecategoria getIddetallecategoria() {
        return iddetallecategoria;
    }

    public void setIddetallecategoria(Detallecategoria iddetallecategoria) {
        this.iddetallecategoria = iddetallecategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idespecificacion != null ? idespecificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especificacionactivo)) {
            return false;
        }
        Especificacionactivo other = (Especificacionactivo) object;
        if ((this.idespecificacion == null && other.idespecificacion != null) || (this.idespecificacion != null && !this.idespecificacion.equals(other.idespecificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Especificacionactivo[ idespecificacion=" + idespecificacion + " ]";
    }
    
}
