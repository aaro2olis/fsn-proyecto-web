package Modelo;
// Generated 10-20-2014 02:19:12 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * Transferencia generated by hbm2java
 */
public class Transferencia  implements java.io.Serializable {


     private int idtransferencia;
     private Activo activo;
     private Date fechatransferencia;
     private String idresponsableantiguo;
     private String idresponsablenuevo;
     private String idubicacionantigua;
     private String idubicacionnueva;

    public Transferencia() {
    }

	
    public Transferencia(int idtransferencia, Activo activo, Date fechatransferencia) {
        this.idtransferencia = idtransferencia;
        this.activo = activo;
        this.fechatransferencia = fechatransferencia;
    }
    public Transferencia(int idtransferencia, Activo activo, Date fechatransferencia, String idresponsableantiguo, String idresponsablenuevo, String idubicacionantigua, String idubicacionnueva) {
       this.idtransferencia = idtransferencia;
       this.activo = activo;
       this.fechatransferencia = fechatransferencia;
       this.idresponsableantiguo = idresponsableantiguo;
       this.idresponsablenuevo = idresponsablenuevo;
       this.idubicacionantigua = idubicacionantigua;
       this.idubicacionnueva = idubicacionnueva;
    }
   
    public int getIdtransferencia() {
        return this.idtransferencia;
    }
    
    public void setIdtransferencia(int idtransferencia) {
        this.idtransferencia = idtransferencia;
    }
    public Activo getActivo() {
        return this.activo;
    }
    
    public void setActivo(Activo activo) {
        this.activo = activo;
    }
    public Date getFechatransferencia() {
        return this.fechatransferencia;
    }
    
    public void setFechatransferencia(Date fechatransferencia) {
        this.fechatransferencia = fechatransferencia;
    }
    public String getIdresponsableantiguo() {
        return this.idresponsableantiguo;
    }
    
    public void setIdresponsableantiguo(String idresponsableantiguo) {
        this.idresponsableantiguo = idresponsableantiguo;
    }
    public String getIdresponsablenuevo() {
        return this.idresponsablenuevo;
    }
    
    public void setIdresponsablenuevo(String idresponsablenuevo) {
        this.idresponsablenuevo = idresponsablenuevo;
    }
    public String getIdubicacionantigua() {
        return this.idubicacionantigua;
    }
    
    public void setIdubicacionantigua(String idubicacionantigua) {
        this.idubicacionantigua = idubicacionantigua;
    }
    public String getIdubicacionnueva() {
        return this.idubicacionnueva;
    }
    
    public void setIdubicacionnueva(String idubicacionnueva) {
        this.idubicacionnueva = idubicacionnueva;
    }




}


