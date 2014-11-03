package Modelo;
// Generated 10-20-2014 02:19:12 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Ubicacionfisica generated by hbm2java
 */
public class Ubicacionfisica  implements java.io.Serializable {


     private String idubicacion;
     private Municipio municipio;
     private Departamento departamento;
     private String nmbubicacion;
     private String dirubicacion;
     private String telefono;
     private String obsubicacion;
     private char estadoubicacion;
     private Set activos = new HashSet(0);

    public Ubicacionfisica() {
    }

	
    public Ubicacionfisica(String idubicacion, Municipio municipio, Departamento departamento, String nmbubicacion, String dirubicacion, String telefono, char estadoubicacion) {
        this.idubicacion = idubicacion;
        this.municipio = municipio;
        this.departamento = departamento;
        this.nmbubicacion = nmbubicacion;
        this.dirubicacion = dirubicacion;
        this.telefono = telefono;
        this.estadoubicacion = estadoubicacion;
    }
    public Ubicacionfisica(String idubicacion, Municipio municipio, Departamento departamento, String nmbubicacion, String dirubicacion, String telefono, String obsubicacion, char estadoubicacion, Set activos) {
       this.idubicacion = idubicacion;
       this.municipio = municipio;
       this.departamento = departamento;
       this.nmbubicacion = nmbubicacion;
       this.dirubicacion = dirubicacion;
       this.telefono = telefono;
       this.obsubicacion = obsubicacion;
       this.estadoubicacion = estadoubicacion;
       this.activos = activos;
    }
   
    public String getIdubicacion() {
        return this.idubicacion;
    }
    
    public void setIdubicacion(String idubicacion) {
        this.idubicacion = idubicacion;
    }
    public Municipio getMunicipio() {
        return this.municipio;
    }
    
    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
    public Departamento getDepartamento() {
        return this.departamento;
    }
    
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    public String getNmbubicacion() {
        return this.nmbubicacion;
    }
    
    public void setNmbubicacion(String nmbubicacion) {
        this.nmbubicacion = nmbubicacion;
    }
    public String getDirubicacion() {
        return this.dirubicacion;
    }
    
    public void setDirubicacion(String dirubicacion) {
        this.dirubicacion = dirubicacion;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getObsubicacion() {
        return this.obsubicacion;
    }
    
    public void setObsubicacion(String obsubicacion) {
        this.obsubicacion = obsubicacion;
    }
    public char getEstadoubicacion() {
        return this.estadoubicacion;
    }
    
    public void setEstadoubicacion(char estadoubicacion) {
        this.estadoubicacion = estadoubicacion;
    }
    public Set getActivos() {
        return this.activos;
    }
    
    public void setActivos(Set activos) {
        this.activos = activos;
    }




}

