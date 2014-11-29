/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

import Modelo.Departamento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FSN-Desarrollo
 */
@Stateless
public class DepartamentoFacade extends AbstractFacade<Departamento> {

    private List<Departamento> items = null;
    @PersistenceContext(unitName = "FSN_Activo_FijoPU")

    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartamentoFacade() {
        super(Departamento.class);
    }

    public boolean findDuplicados(String nmbdpto) {
        String nmbDpto;
        boolean existe = false;
        if (items == null) {
            items = (List<Departamento>) getEntityManager().createNamedQuery("Departamento.findAll", Departamento.class).getResultList();
        }
        for (int j = 0; j < items.size(); j++) {
            nmbDpto = items.get(j).getNmbdpto().toUpperCase();
            if ((nmbDpto.equals(nmbdpto.toUpperCase()))) {
                j = items.size();
                existe = true;
            }
        }
        return existe;
    }
    public boolean findDuplicados(String nmbdpto, Integer iddpto) {
        String nmbDpto;
        Integer itemsIddepto;
        boolean existe = false;
        if (items == null) {
            items = (List<Departamento>) getEntityManager().createNamedQuery("Departamento.findAll", Departamento.class).getResultList();
        }
        for (int j = 0; j < items.size(); j++) {
            nmbDpto = items.get(j).getNmbdpto().toUpperCase();
            itemsIddepto = items.get(j).getIddpto();
            if (nmbDpto.equals(nmbdpto)) {
                if (!(itemsIddepto == iddpto))
                {
                j = items.size();
                existe = true;
                }
            }
        }
        return existe;
    }    
}
