/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

import Modelo.Ubicacionfisica;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FSN-Desarrollo
 */
@Stateless
public class UbicacionfisicaFacade extends AbstractFacade<Ubicacionfisica> {

    @PersistenceContext(unitName = "FSN_Activo_FijoPU")
    private EntityManager em;
    private List<Ubicacionfisica> items;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UbicacionfisicaFacade() {
        super(Ubicacionfisica.class);
    }

    public boolean findDuplicados(String nmbubicacion, Integer iddpto, Integer idmunicipio) {
        String nmbUbicacion;
        Integer idDpto;
        Integer idMunicipio;
        boolean existe = false;
        if (items == null) {
            items = (List<Ubicacionfisica>) getEntityManager().createNamedQuery("Ubicacionfisica.findAll", Ubicacionfisica.class)
                    .setParameter("estadoubicacion", '0')
                    .getResultList();
        }
        for (int j = 0; j < items.size(); j++) {
            nmbUbicacion = items.get(j).getNmbubicacion().trim();
            idDpto = items.get(j).getIddpto().getIddpto();
            idMunicipio = items.get(j).getIdmunicipio().getIdmunicipio();
            if ((nmbUbicacion.equalsIgnoreCase(nmbubicacion.trim())) && (idDpto.equals(iddpto))&& (idMunicipio.equals(idmunicipio))) {
                j = items.size();
                existe = true;
            }
        }
        return existe;
    }

     public boolean findDuplicados(String nmbubicacion, Integer iddpto, Integer idmunicipio,Integer idubicacion) {
        String nmbUbicacion;
        Integer idDpto;
        Integer idMunicipio;
        Integer idUbicacion=idubicacion;
        boolean existe = false;
        if (items == null) {
            items = (List<Ubicacionfisica>) getEntityManager().createNamedQuery("Ubicacionfisica.findAll", Ubicacionfisica.class)
                    .setParameter("estadoubicacion", '0')
                    .getResultList();
        }
        for (int j = 0; j < items.size(); j++) {
            nmbUbicacion = items.get(j).getNmbubicacion().trim();
            idDpto = items.get(j).getIddpto().getIddpto();
            idMunicipio = items.get(j).getIdmunicipio().getIdmunicipio();
            if ((nmbUbicacion.equalsIgnoreCase(nmbubicacion.trim())) && (idDpto.equals(iddpto))&& (idMunicipio.equals(idmunicipio))) {
                idUbicacion = items.get(j).getIdubicacion();
                if (!(idUbicacion.equals(idubicacion))) {
                    j = items.size();
                    existe = true;
                }
            }
        }
        return existe;
    }   
   }
