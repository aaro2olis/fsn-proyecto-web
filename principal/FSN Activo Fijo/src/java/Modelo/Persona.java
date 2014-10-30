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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByIdpersona", query = "SELECT p FROM Persona p WHERE p.idpersona = :idpersona"),
    @NamedQuery(name = "Persona.findByNombrerazon", query = "SELECT p FROM Persona p WHERE p.nombrerazon = :nombrerazon"),
    @NamedQuery(name = "Persona.findByDireccion", query = "SELECT p FROM Persona p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Persona.findByTelefono", query = "SELECT p FROM Persona p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Persona.findByCorreo", query = "SELECT p FROM Persona p WHERE p.correo = :correo"),
    @NamedQuery(name = "Persona.findByNit", query = "SELECT p FROM Persona p WHERE p.nit = :nit"),
    @NamedQuery(name = "Persona.findByDui", query = "SELECT p FROM Persona p WHERE p.dui = :dui")})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpersona")
    private Integer idpersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombrerazon")
    private String nombrerazon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 17)
    @Column(name = "nit")
    private String nit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "dui")
    private String dui;
    @ManyToMany(mappedBy = "personaCollection")
    private Collection<Mantenimiento> mantenimientoCollection;
    @OneToMany(mappedBy = "perIdpersona")
    private Collection<Persona> personaCollection;
    @JoinColumn(name = "per_idpersona", referencedColumnName = "idpersona")
    @ManyToOne
    private Persona perIdpersona;
    @JoinColumn(name = "idrolpersona", referencedColumnName = "idrolpersona")
    @ManyToOne
    private Rolpersona idrolpersona;
    @JoinColumn(name = "idtipopersona", referencedColumnName = "idtipopersona")
    @ManyToOne(optional = false)
    private Tipopersona idtipopersona;
    @OneToMany(mappedBy = "idpersona")
    private Collection<Desafectacion> desafectacionCollection;
    @OneToMany(mappedBy = "idpersona")
    private Collection<Activo> activoCollection;

    public Persona() {
    }

    public Persona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public Persona(Integer idpersona, String nombrerazon, String direccion, String telefono, String correo, String nit, String dui) {
        this.idpersona = idpersona;
        this.nombrerazon = nombrerazon;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.nit = nit;
        this.dui = dui;
    }

    public Integer getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombrerazon() {
        return nombrerazon;
    }

    public void setNombrerazon(String nombrerazon) {
        this.nombrerazon = nombrerazon;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    @XmlTransient
    public Collection<Mantenimiento> getMantenimientoCollection() {
        return mantenimientoCollection;
    }

    public void setMantenimientoCollection(Collection<Mantenimiento> mantenimientoCollection) {
        this.mantenimientoCollection = mantenimientoCollection;
    }

    @XmlTransient
    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }

    public Persona getPerIdpersona() {
        return perIdpersona;
    }

    public void setPerIdpersona(Persona perIdpersona) {
        this.perIdpersona = perIdpersona;
    }

    public Rolpersona getIdrolpersona() {
        return idrolpersona;
    }

    public void setIdrolpersona(Rolpersona idrolpersona) {
        this.idrolpersona = idrolpersona;
    }

    public Tipopersona getIdtipopersona() {
        return idtipopersona;
    }

    public void setIdtipopersona(Tipopersona idtipopersona) {
        this.idtipopersona = idtipopersona;
    }

    @XmlTransient
    public Collection<Desafectacion> getDesafectacionCollection() {
        return desafectacionCollection;
    }

    public void setDesafectacionCollection(Collection<Desafectacion> desafectacionCollection) {
        this.desafectacionCollection = desafectacionCollection;
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
        hash += (idpersona != null ? idpersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idpersona == null && other.idpersona != null) || (this.idpersona != null && !this.idpersona.equals(other.idpersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombrerazon;
    }
    
}
