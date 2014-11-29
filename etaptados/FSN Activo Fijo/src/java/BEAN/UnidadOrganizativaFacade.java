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
    private List<UnidadOrganizativa> items = null;
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
            if ((Objects.equals(items.get(j).getUniIdunidad().getIdunidad(), uniIdUnidad)) && (nmbUnidad.equals(items.get(j).getNmbunidad().toUpperCase()))) {
                if (!(items.get(j).getEstadounidad().toString().equals("0"))) {
                    j = items.size();
                    existe = true;
                }
            }
        }
        return existe;
    }

    public boolean findDuplicados(String nmbunidad, Integer uniIdunidad, Integer idunidad) {
        String nmbUnidad;
        Integer uniIdUnidad;
        Integer idUnidad;
        boolean existe = false;
        if (items == null) {
            items = (List<UnidadOrganizativa>) getEntityManager().createNamedQuery("UnidadOrganizativa.findAll", UnidadOrganizativa.class)
                    .setParameter("estadounidad", '0')
                    .getResultList();
        }
        for (int j = 0; j < items.size(); j++) {
            nmbUnidad = items.get(j).getNmbunidad().toUpperCase();
            uniIdUnidad = items.get(j).getUniIdunidad().getIdunidad();
            if ((uniIdUnidad == uniIdunidad) && (nmbUnidad.equals(nmbunidad))) {
                idUnidad = items.get(j).getIdunidad();
                if (!(items.get(j).getEstadounidad().toString().equals("0"))) {
                    if (!(idUnidad == idunidad)) {
                        j = items.size();
                        existe = true;
                    }
                }
            }

        }
        return existe;
    }
}
