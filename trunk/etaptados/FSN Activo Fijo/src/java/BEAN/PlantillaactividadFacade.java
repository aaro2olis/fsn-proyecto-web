/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

import Modelo.Plantillaactividad;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FSN-Desarrollo
 */
@Stateless
public class PlantillaactividadFacade extends AbstractFacade<Plantillaactividad> {
    private List<Plantillaactividad> items = null;
    @PersistenceContext(unitName = "FSN_Activo_FijoPU")
    private EntityManager em;


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlantillaactividadFacade() {
        super(Plantillaactividad.class);
    }

    public boolean findDuplicados(String dscplantilla, Integer idrol) {
        String dscPlantilla;
        Integer idRol;
        boolean existe = false;
        if (items == null) {
            items = (List<Plantillaactividad>) getEntityManager().createNamedQuery("Plantillaactividad.findAll", Plantillaactividad.class)
                    .setParameter("estadoplantilla", '0')
                    .getResultList();
       }
        for (int j = 0; j < items.size(); j++) {
            dscPlantilla = items.get(j).getDscplantilla().trim();
            idRol = items.get(j).getIdrol().getIdrol();
            if ((idRol.equals(idrol)) && (dscPlantilla.equalsIgnoreCase(dscplantilla.trim()))) {
                j = items.size();
                existe = true;
            }
        }
        return existe;
    }

    public boolean findDuplicados(String dscplantilla, Integer idrol, Integer idplantilla) {
        String dscPlantilla;
        Integer idRol;
        Integer idPlantilla;
        boolean existe = false;
        if (items == null) {
            items = (List<Plantillaactividad>) getEntityManager().createNamedQuery("Plantillaactividad.findAll", Plantillaactividad.class)
                    .setParameter("estadoplantilla", '0')
                    .getResultList();
        }
        for (int j = 0; j < items.size(); j++) {
            dscPlantilla = items.get(j).getDscplantilla().trim();
            idRol = items.get(j).getIdrol().getIdrol();
            if ((idRol.equals(idrol)) && (dscPlantilla.equalsIgnoreCase(dscplantilla.trim()))) {
                idPlantilla = items.get(j).getIdplantilla();
                if (!(idPlantilla.equals(idplantilla))) {
                    j = items.size();
                    existe = true;
                }
            }
        }
        return existe;
    }
}
