/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FSN-Desarrollo
 */
@Entity
@Table(name = "activo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activo.findAll", query = "SELECT a FROM Activo a"),
    @NamedQuery(name = "Activo.findByIdactivo", query = "SELECT a FROM Activo a WHERE a.idactivo = :idactivo"),
    @NamedQuery(name = "Activo.findByNmbactivo", query = "SELECT a FROM Activo a WHERE a.nmbactivo = :nmbactivo"),
    @NamedQuery(name = "Activo.findByDscactivo", query = "SELECT a FROM Activo a WHERE a.dscactivo = :dscactivo"),
    @NamedQuery(name = "Activo.findByObsactivo", query = "SELECT a FROM Activo a WHERE a.obsactivo = :obsactivo"),
    @NamedQuery(name = "Activo.findByMarcaactivo", query = "SELECT a FROM Activo a WHERE a.marcaactivo = :marcaactivo"),
    @NamedQuery(name = "Activo.findByModeloactivo", query = "SELECT a FROM Activo a WHERE a.modeloactivo = :modeloactivo"),
    @NamedQuery(name = "Activo.findByFechaAdquisicion", query = "SELECT a FROM Activo a WHERE a.fechaAdquisicion = :fechaAdquisicion"),
    @NamedQuery(name = "Activo.findByEstadoactivo", query = "SELECT a FROM Activo a WHERE a.estadoactivo = :estadoactivo"),
    @NamedQuery(name = "Activo.findByCostoadquicision", query = "SELECT a FROM Activo a WHERE a.costoadquicision = :costoadquicision"),
    @NamedQuery(name = "Activo.findByValorresidual", query = "SELECT a FROM Activo a WHERE a.valorresidual = :valorresidual"),
    @NamedQuery(name = "Activo.findByNuevo", query = "SELECT a FROM Activo a WHERE a.nuevo = :nuevo")})
public class Activo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "idactivo")
    private String idactivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nmbactivo")
    private String nmbactivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "dscactivo")
    private String dscactivo;
    @Basic(optional = false)
    @Size(min = 1, max = 200)
    @Column(name = "obsactivo")
    private String obsactivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "marcaactivo")
    private String marcaactivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "modeloactivo")
    private String modeloactivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_adquisicion")
    @Temporal(TemporalType.DATE)
    private Date fechaAdquisicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoactivo")
    private Character estadoactivo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "costoadquicision")
    private BigDecimal costoadquicision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorresidual")
    private BigDecimal valorresidual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nuevo")
    private Character nuevo;
    @OneToMany(mappedBy = "idactivo")
    private Collection<Mantenimiento> mantenimientoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idactivo")
    private Collection<Inventario> inventarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idactivo")
    private Collection<Transferencia> transferenciaCollection;
    @OneToMany(mappedBy = "idactivo")
    private Collection<Especificacionactivo> especificacionactivoCollection;
    @JoinColumn(name = "idcategoria", referencedColumnName = "idcategoria")
    @ManyToOne(optional = false)
    private Categoria idcategoria;
    @JoinColumn(name = "idempleado", referencedColumnName = "idempleado")
    @ManyToOne
    private Empleado idempleado;
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @ManyToOne
    private Persona idpersona;
    @JoinColumn(name = "idtipoactivo", referencedColumnName = "idtipoactivo")
    @ManyToOne
    private Tipoactivo idtipoactivo;
    @JoinColumn(name = "idtipoestado", referencedColumnName = "idtipoestado")
    @ManyToOne(optional = false)
    private Tipoestado idtipoestado;
    @JoinColumn(name = "idmodalidad", referencedColumnName = "idmodalidad")
    @ManyToOne
    private Tipomodalidad idmodalidad;
    @JoinColumn(name = "idubicacion", referencedColumnName = "idubicacion")
    @ManyToOne(optional = false)
    private Ubicacionfisica idubicacion;

    public Activo() {
    }

    public Activo(String idactivo) {
        this.idactivo = idactivo;
    }

    public Activo(String idactivo, String nmbactivo, String dscactivo, String obsactivo, String marcaactivo, String modeloactivo, Date fechaAdquisicion, Character estadoactivo, BigDecimal costoadquicision, BigDecimal valorresidual, Character nuevo) {
        this.idactivo = idactivo;
        this.nmbactivo = nmbactivo;
        this.dscactivo = dscactivo;
        this.obsactivo = obsactivo;
        this.marcaactivo = marcaactivo;
        this.modeloactivo = modeloactivo;
        this.fechaAdquisicion = fechaAdquisicion;
        this.estadoactivo = estadoactivo;
        this.costoadquicision = costoadquicision;
        this.valorresidual = valorresidual;
        this.nuevo = nuevo;
    }

    public String getIdactivo() {
        return idactivo;
    }

    public void setIdactivo(String idactivo) {
        this.idactivo = idactivo;
    }

    public String getNmbactivo() {
        return nmbactivo;
    }

    public void setNmbactivo(String nmbactivo) {
        this.nmbactivo = nmbactivo;
    }

    public String getDscactivo() {
        return dscactivo;
    }

    public void setDscactivo(String dscactivo) {
        this.dscactivo = dscactivo;
    }

    public String getObsactivo() {
        return obsactivo;
    }

    public void setObsactivo(String obsactivo) {
        this.obsactivo = obsactivo;
    }

    public String getMarcaactivo() {
        return marcaactivo;
    }

    public void setMarcaactivo(String marcaactivo) {
        this.marcaactivo = marcaactivo;
    }

    public String getModeloactivo() {
        return modeloactivo;
    }

    public void setModeloactivo(String modeloactivo) {
        this.modeloactivo = modeloactivo;
    }

    public Date getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(Date fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public int getEstadoActivo() {
        return estadoactivo;
    }

    public void setEstadoActivo(Character estadoactivo) {
        this.estadoactivo = estadoactivo;
    }

   /* public void setEstadoActivo(Character estadoactivo) {
        Integer C = new Integer(0);
        if (estadoactivo.equals("0")) {
            this.estadoactivo = C;
        } else {
            this.estadoactivo = Integer.parseInt(estadoactivo);
        }
    }

    public void setEstadoActivo(Character estadoactivo) {
        Character C = new Character('0');
        if (estadoactivo == '0') {
            this.estadoactivo = 0;
        }
    }*/

    public void setEstadoActivo() {
        //Al momento de crearse 0 para eliminados
        this.estadoactivo = 1;
    }

    public BigDecimal getCostoadquicision() {
        return costoadquicision;
    }

    public void setCostoadquicision(BigDecimal costoadquicision) {
        this.costoadquicision = costoadquicision;
    }

    public BigDecimal getValorresidual() {
        return valorresidual;
    }

    public void setValorresidual(BigDecimal valorresidual) {
        this.valorresidual = valorresidual;
    }

    public Character getNuevo() {
        return nuevo;
    }

    public String getNuevoNombre() {
        //return nuevo;
        return getCompraActivo(nuevo);
    }

    public void setNuevo(Character nuevo) {
        this.nuevo = nuevo;
    }

    public void setNuevo(String nuevo) {
        switch (nuevo) {
            case "1":
                this.nuevo = '1';
                break;
            case "2":
                this.nuevo = '2';
                break;
            case "3":
                this.nuevo = '3';
                break;
            case "4":
                this.nuevo = '4';
                break;
            case "5":
                this.nuevo = '5';
                break;
            default:
                this.nuevo = '6';
                break;
        }
    }

    public String getCompraActivo(Character nuevo) {
        String nombreEstadoCompraActivo = null;
        switch (nuevo) {
            case '0':
                nombreEstadoCompraActivo = "Nuevo";
                break;
            case '1':
                nombreEstadoCompraActivo = "Usado 1 año";
                break;
            case '2':
                nombreEstadoCompraActivo = "Usado 2 años";
                break;
            case '3':
                nombreEstadoCompraActivo = "Usado 3 años";
                break;
            case '4':
                nombreEstadoCompraActivo = "Usado 4 años";
                break;
        }
        return nombreEstadoCompraActivo;
    }

    @XmlTransient
    public Collection<Mantenimiento> getMantenimientoCollection() {
        return mantenimientoCollection;
    }

    public void setMantenimientoCollection(Collection<Mantenimiento> mantenimientoCollection) {
        this.mantenimientoCollection = mantenimientoCollection;
    }

    @XmlTransient
    public Collection<Inventario> getInventarioCollection() {
        return inventarioCollection;
    }

    public void setInventarioCollection(Collection<Inventario> inventarioCollection) {
        this.inventarioCollection = inventarioCollection;
    }

    @XmlTransient
    public Collection<Transferencia> getTransferenciaCollection() {
        return transferenciaCollection;
    }

    public void setTransferenciaCollection(Collection<Transferencia> transferenciaCollection) {
        this.transferenciaCollection = transferenciaCollection;
    }

    @XmlTransient
    public Collection<Especificacionactivo> getEspecificacionactivoCollection() {
        return especificacionactivoCollection;
    }

    public void setEspecificacionactivoCollection(Collection<Especificacionactivo> especificacionactivoCollection) {
        this.especificacionactivoCollection = especificacionactivoCollection;
    }

    public Categoria getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Categoria idcategoria) {
        this.idcategoria = idcategoria;
    }

    public Empleado getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Empleado idempleado) {
        this.idempleado = idempleado;
    }

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
    }

    public Tipoactivo getIdtipoactivo() {
        return idtipoactivo;
    }

    public void setIdtipoactivo(Tipoactivo idtipoactivo) {
        this.idtipoactivo = idtipoactivo;
    }

    public Tipoestado getIdtipoestado() {
        return idtipoestado;
    }

    public void setIdtipoestado(Tipoestado idtipoestado) {
        //Estado del activo robado, en oficinas, en prestamo, alquilado, en mantenimiento,etc
        this.idtipoestado = idtipoestado;
    }

    public Tipomodalidad getIdmodalidad() {
        return idmodalidad;
    }

    public void setIdmodalidad(Tipomodalidad idmodalidad) {
        this.idmodalidad = idmodalidad;
    }

    public Ubicacionfisica getIdubicacion() {
        return idubicacion;
    }

    public void setIdubicacion(Ubicacionfisica idubicacion) {
        this.idubicacion = idubicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idactivo != null ? idactivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activo)) {
            return false;
        }
        Activo other = (Activo) object;
        if ((this.idactivo == null && other.idactivo != null) || (this.idactivo != null && !this.idactivo.equals(other.idactivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idactivo;
    }

}
