/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BEAN;

import Modelo.Municipio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author FSN-Desarrollo
 */
@Stateless
public class MunicipioFacade extends AbstractFacade<Municipio> {

    public MunicipioFacade() {
        super(Municipio.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
