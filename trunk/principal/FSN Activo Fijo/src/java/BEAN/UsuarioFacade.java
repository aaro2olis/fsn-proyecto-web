/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BEAN;

import Modelo.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author FSN-Desarrollo
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {
    @PersistenceContext(unitName = "FSN_Activo_FijoPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    /**
     * Metodo que permite verificar la existencia de un usuario
     * @param idusuario codigo del usuario
     * @param password clave del usuario
     * @return true o false 
     */
    public boolean buscaUsuario(String idusuario, String password){
        TypedQuery<Usuario> query = em.createQuery("SELECT c FROM Usuario c WHERE c.idusuario = :id AND c.password = :pass", Usuario.class);
        query.setParameter("id", idusuario);
        query.setParameter("pass", password);
        Usuario user = query.getSingleResult();
        Boolean bandera;
        if(user!= null){
            bandera = false;
        }
        bandera= true;
      return bandera;  
    }
}