/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

import Modelo.UnidadOrganizativa;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FSN-Desarrollo
 */
@Stateless
public class UnidadOrganizativaFacade extends AbstractFacade<UnidadOrganizativa> {

    private List<UnidadOrganizativa> items;
    @PersistenceContext(unitName = "FSN_Activo_FijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UnidadOrganizativaFacade() {
        super(UnidadOrganizativa.class);
    }

    public boolean findDuplicados(String nmbUnidad, Integer uniIdUnidad) {
        String nmbunidad;
        Integer uni_idunidad;
        Integer idunidad;
        boolean existe = false;
        if (items == null) {
            items = (List<UnidadOrganizativa>) getEntityManager().createNamedQuery("UnidadOrganizativa.findAll", UnidadOrganizativa.class)
                    .setParameter("estadounidad", '0')
                    .getResultList();
        }
        for (int j = 0; j < items.size(); j++) {
            nmbunidad = items.get(j).getNmbunidad().trim();
            if(items.get(j).getUniIdunidad() == null){
                uni_idunidad=0;
            }else{
            uni_idunidad = items.get(j).getUniIdunidad().getIdunidad();
            }
            if ((uni_idunidad.equals(uniIdUnidad)) && (nmbunidad.equalsIgnoreCase(nmbUnidad.trim()))) {
                j = items.size();
                existe = true;
            }
        }
        return existe;
    }

    public boolean findDuplicados(String nmbUnidad, Integer uniIdUnidad, Integer idunidad) {
        String nmbunidad;
        Integer uni_idunidad;
        Integer idUnidad;
        boolean existe = false;
        if (items == null) {
            items = (List<UnidadOrganizativa>) getEntityManager().createNamedQuery("UnidadOrganizativa.findAll", UnidadOrganizativa.class)
                    .setParameter("estadounidad", '0')
                    .getResultList();
        }
        for (int j = 0; j < items.size(); j++) {
            nmbunidad = items.get(j).getNmbunidad().trim();
            if(items.get(j).getUniIdunidad() == null){
                uni_idunidad=0;
            }else{
            uni_idunidad = items.get(j).getUniIdunidad().getIdunidad();
            }
            if ((uni_idunidad.equals(uniIdUnidad)) && (nmbunidad.equalsIgnoreCase(nmbUnidad.trim()))) 
                {
                idUnidad = items.get(j).getIdunidad();
                    if (!(idUnidad.equals(idunidad))) {
                        j = items.size();
                        existe = true;
                }
            }

        }
        return existe;
    }
}
