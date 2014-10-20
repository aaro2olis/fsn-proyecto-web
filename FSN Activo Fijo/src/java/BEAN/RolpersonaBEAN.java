/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BEAN;

import Controlador.RolpersonaControlador;
import Modelo.Rolpersona;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Miguel
 */
@ManagedBean
@RequestScoped
public class RolpersonaBEAN {
     private int idrolpersona;
     private String nmbrolpersona;
     private String dscrol;
     private RolpersonaControlador rolpersonacontrolador;
    /**
     * Creates a new instance of RolpersonaBEAN
     */
    

    /**
     * @return the idrolpersona
     */
    public int getIdrolpersona() {
        return idrolpersona;
    }

    /**
     * @param idrolpersona the idrolpersona to set
     */
    public void setIdrolpersona(int idrolpersona) {
        this.idrolpersona = idrolpersona;
    }

    /**
     * @return the nmbrolpersona
     */
    public String getNmbrolpersona() {
        return nmbrolpersona;
    }

    /**
     * @param nmbrolpersona the nmbrolpersona to set
     */
    public void setNmbrolpersona(String nmbrolpersona) {
        this.nmbrolpersona = nmbrolpersona;
    }

    /**
     * @return the dscrol
     */
    public String getDscrol() {
        return dscrol;
    }

    /**
     * @param dscrol the dscrol to set
     */
    public void setDscrol(String dscrol) {
        this.dscrol = dscrol;
    }

    /**
     * @return the rolpersonacontrolador
     */
    public RolpersonaControlador getRolpersonacontrolador() {
        return rolpersonacontrolador;
    }

    /**
     * @param rolpersonacontrolador the rolpersonacontrolador to set
     */
    public void setRolpersonacontrolador(RolpersonaControlador rolpersonacontrolador) {
        this.rolpersonacontrolador = rolpersonacontrolador;
    }
    
     public String insertar() {
        Rolpersona c = new Rolpersona();
        c.setIdrolpersona(this.getIdrolpersona());
        c.setNmbrolpersona(this.getNmbrolpersona());
        c.setDscrol(this.getDscrol());
        rolpersonacontrolador = new RolpersonaControlador();
        rolpersonacontrolador.insertar(c);
        return "";

    }
    
}
