/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

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

    public boolean findDuplicados(String nmbmunicipio, Integer iddpto) {
        String nmbMunicipio;
        Integer itemsIddepto;
        boolean existe = false;
        if (items == null) {
            items = (List<Municipio>) getEntityManager().createNamedQuery("Municipio.findAll", Municipio.class).getResultList();
        }
        for (int j = 0; j < items.size(); j++) {
            nmbMunicipio = items.get(j).getNmbmunicipio().toUpperCase();
            itemsIddepto = items.get(j).getIddpto().getIddpto();
            if ((itemsIddepto == iddpto) && (nmbMunicipio.equals(nmbmunicipio.toUpperCase()))) {
                j = items.size();
                existe = true;
            }
        }
        return existe;
    }

    public boolean findDuplicados(String nmbmunicipio, Integer iddpto, Integer idmunicipio) {
        String nmbMunicipio;
        Integer itemsIddepto;
        Integer idMunicipio;
        boolean existe = false;
        if (items == null) {
            items = (List<Municipio>) getEntityManager().createNamedQuery("Municipio.findAll", Municipio.class).getResultList();
        }
        for (int j = 0; j < items.size(); j++) {
            nmbMunicipio = items.get(j).getNmbmunicipio().toUpperCase();
            itemsIddepto = items.get(j).getIddpto().getIddpto();
            if ((itemsIddepto == iddpto) && (nmbMunicipio.equals(nmbmunicipio.toUpperCase()))) {
                idMunicipio = items.get(j).getIdmunicipio();
                if (!(idMunicipio == idmunicipio)) {
                    j = items.size();
                    existe = true;
                }
            }
        }
        return existe;
    }
}
