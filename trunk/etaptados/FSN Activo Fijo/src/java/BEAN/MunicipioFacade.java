/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

import Modelo.Mantenimiento;
import Modelo.Municipio;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FSN-Desarrollo
 */
@Stateless
public class MunicipioFacade extends AbstractFacade<Municipio> {

    private List<Municipio> items = null;
    @PersistenceContext(unitName = "FSN_Activo_FijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MunicipioFacade() {
        super(Municipio.class);
    }

    public List<Municipio> getItemsByIdDepto() {
        if (items == null) {
            items = (List<Municipio>) getEntityManager().createNamedQuery("Municipio.findAllCriterioIntegerIddepto", Municipio.class).getResultList();
        }
        return items;
    }
     public List<Municipio> findAllOrderByDepto() {
        if (items == null) {
            items = (List<Municipio>) getEntityManager().createNamedQuery("Municipio.findAll", Municipio.class).getResultList();
        }
        return items;
    }   

}
