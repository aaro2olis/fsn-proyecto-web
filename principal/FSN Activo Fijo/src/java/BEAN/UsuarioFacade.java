/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

import Modelo.Usuario;
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
       
        System.out.println("MD5"+getStringMessageDigest(password,"MD5"));
        /*codificar clave en md5*/
        String ps = getStringMessageDigest(password,"MD5");
        TypedQuery<Usuario> query = em.createQuery("SELECT c FROM Usuario c WHERE c.idusuario = :id AND c.password = :pass", Usuario.class);
        query.setParameter("id", idusuario);
        query.setParameter("pass", ps);
        Usuario user = query.getSingleResult();
        System.out.println("user" + user);
        Boolean bandera;
        if (user != null) {
            bandera = false;
        }
        bandera = true;
        return bandera;
    }

    /**
     * *
     * Encripta un mensaje de texto mediante algoritmo de resumen de mensaje.
     *
     * @param message texto a encriptar
     * @param algorithm algoritmo de encriptacion, puede ser: MD2, MD5, SHA-1,
     * SHA-256, SHA-384, SHA-51
     *
     * @return mensaje encriptado
     *
     */
    public static String getStringMessageDigest(String message, String algorithm) {

        byte[] digest = null;

        byte[] buffer = message.getBytes();

        try {

            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);

            messageDigest.reset();

            messageDigest.update(buffer);

            digest = messageDigest.digest();

        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Error creando Digest");

        }

        return toHexadecimal(digest);

    }
/***

     * Convierte un arreglo de bytes a String usando valores hexadecimales

     * @param digest arreglo de bytes a convertir

     * @return String creado a partir de <code>digest</code>

     */

    private static String toHexadecimal(byte[] digest){

        String hash = "";

        for(byte aux : digest) {

            int b = aux & 0xff;

            if (Integer.toHexString(b).length() == 1) hash += "0";

            hash += Integer.toHexString(b);

        }

        return hash;

    }
    
    public String nuevoUsuario(Usuario usuario){
        Usuario usuarioNuevo = new Usuario();
        usuarioNuevo.setIdusuario(usuario.getIdusuario());
        usuarioNuevo.setIdempleado(usuario.getIdempleado());
        usuarioNuevo.setEstadousuario(Character.MIN_VALUE);
        usuarioNuevo.setIdrol(usuario.getIdrol());
        usuarioNuevo.setPassword(usuario.getPassword());
        usuarioNuevo.setActividadCollection(null);
        em.persist(usuarioNuevo);
        return "exito";
        
    }
        
    
}
