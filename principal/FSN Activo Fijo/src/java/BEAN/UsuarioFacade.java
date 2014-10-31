/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

import Modelo.Usuario;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
     *
     * @param idusuario codigo del usuario
     * @param password clave del usuario
     * @return true o false
     */
    public boolean buscaUsuario(String idusuario, String password) {
        System.out.println("password--"+password);
        String encriptado = Base64.encode(password.getBytes());
        System.out.println("encriptado"+encriptado);
        TypedQuery<Usuario> query = em.createQuery("SELECT c FROM Usuario c WHERE c.idusuario = :id AND c.password = :pass", Usuario.class);
        query.setParameter("id", idusuario);
        query.setParameter("pass", encriptado);
        Usuario user = query.getSingleResult();
        System.out.println("user" + user);
        Boolean bandera;
        if (user != null) {
            bandera = false;
        }
        bandera = true;
        return bandera;
    }

   
    
//    public String nuevoUsuario(Usuario usuario){
//        Usuario usuarioNuevo = new Usuario();
//        usuarioNuevo.setIdusuario(usuario.getIdusuario());
//        usuarioNuevo.setIdempleado(usuario.getIdempleado());
//        usuarioNuevo.setEstadousuario(Character.MIN_VALUE);
//        usuarioNuevo.setIdrol(usuario.getIdrol());
//        usuarioNuevo.setPassword(usuario.getPassword());
//        usuarioNuevo.setActividadCollection(null);
//        em.persist(usuarioNuevo);
//        return "exito";
//        
//    }
//        
    
}
