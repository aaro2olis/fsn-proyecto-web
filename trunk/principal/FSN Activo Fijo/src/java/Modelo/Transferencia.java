/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FSN-Desarrollo
 */
@Entity
@Table(name = "transferencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transferencia.findAll", query = "SELECT t FROM Transferencia t"),
    @NamedQuery(name = "Transferencia.findByIdtransferencia", query = "SELECT t FROM Transferencia t WHERE t.idtransferencia = :idtransferencia"),
    @NamedQuery(name = "Transferencia.findByFechatransferencia", query = "SELECT t FROM Transferencia t WHERE t.fechatransferencia = :fechatransferencia"),
    @NamedQuery(name = "Transferencia.findByIdresponsableantiguo", query = "SELECT t FROM Transferencia t WHERE t.idresponsableantiguo = :idresponsableantiguo"),
    @NamedQuery(name = "Transferencia.findByIdresponsablenuevo", query = "SELECT t FROM Transferencia t WHERE t.idresponsablenuevo = :idresponsablenuevo"),
    @NamedQuery(name = "Transferencia.findByIdubicacionantigua", query = "SELECT t FROM Transferencia t WHERE t.idubicacionantigua = :idubicacionantigua"),
    @NamedQuery(name = "Transferencia.findByIdubicacionnueva", query = "SELECT t FROM Transferencia t WHERE t.idubicacionnueva = :idubicacionnueva")})
public class Transferencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtransferencia")
    private Integer idtransferencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechatransferencia")
    @Temporal(TemporalType.DATE)
    private Date fechatransferencia;
    @Size(max = 10)
    @Column(name = "idresponsableantiguo")
    private String idresponsableantiguo;
    @Size(max = 10)
    @Column(name = "idresponsablenuevo")
    private String idresponsablenuevo;
    @Size(max = 3)
    @Column(name = "idubicacionantigua")
    private String idubicacionantigua;
    @Size(max = 3)
    @Column(name = "idubicacionnueva")
    private String idubicacionnueva;
    @JoinColumn(name = "idactivo", referencedColumnName = "idactivo")
    @ManyToOne(optional = false)
    private Activo idactivo;

    public Transferencia() {
    }

    public Transferencia(Integer idtransferencia) {
        this.idtransferencia = idtransferencia;
    }

    public Transferencia(Integer idtransferencia, Date fechatransferencia) {
        this.idtransferencia = idtransferencia;
        this.fechatransferencia = fechatransferencia;
    }

    public Integer getIdtransferencia() {
        return idtransferencia;
    }

    public void setIdtransferencia(Integer idtransferencia) {
        this.idtransferencia = idtransferencia;
    }

    public Date getFechatransferencia() {
        return fechatransferencia;
    }

    public void setFechatransferencia(Date fechatransferencia) {
        this.fechatransferencia = fechatransferencia;
    }

    public String getIdresponsableantiguo() {
        return idresponsableantiguo;
    }

    public void setIdresponsableantiguo(String idresponsableantiguo) {
        this.idresponsableantiguo = idresponsableantiguo;
    }

    public String getIdresponsablenuevo() {
        return idresponsablenuevo;
    }

    public void setIdresponsablenuevo(String idresponsablenuevo) {
        this.idresponsablenuevo = idresponsablenuevo;
    }

    public String getIdubicacionantigua() {
        return idubicacionantigua;
    }

    public void setIdubicacionantigua(String idubicacionantigua) {
        this.idubicacionantigua = idubicacionantigua;
    }

    public String getIdubicacionnueva() {
        return idubicacionnueva;
    }

    public void setIdubicacionnueva(String idubicacionnueva) {
        this.idubicacionnueva = idubicacionnueva;
    }

    public Activo getIdactivo() {
        return idactivo;
    }

    public void setIdactivo(Activo idactivo) {
        this.idactivo = idactivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtransferencia != null ? idtransferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transferencia)) {
            return false;
        }
        Transferencia other = (Transferencia) object;
        if ((this.idtransferencia == null && other.idtransferencia != null) || (this.idtransferencia != null && !this.idtransferencia.equals(other.idtransferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Transferencia[ idtransferencia=" + idtransferencia + " ]";
    }
    
}
