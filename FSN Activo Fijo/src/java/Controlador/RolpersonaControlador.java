/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import DAO.RolpersonaDAO;
import Modelo.Rolpersona;

/**
 *
 * @author Miguel
 */
public class RolpersonaControlador {
    private RolpersonaDAO rolpersonadao;
    
    public void insertar(Rolpersona rolpersona) {
        setRolpersonadao(new RolpersonaDAO());
       rolpersonadao.insertar(rolpersona);
    }

    /**
     * @return the rolpersonadao
     */
    public RolpersonaDAO getRolpersonadao() {
        return rolpersonadao;
    }

    /**
     * @param rolpersonadao the rolpersonadao to set
     */
    public void setRolpersonadao(RolpersonaDAO rolpersonadao) {
        this.rolpersonadao = rolpersonadao;
    }
    
}
