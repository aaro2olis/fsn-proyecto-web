/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

import Modelo.Activo;
import Modelo.Empleado;
import Modelo.Ubicacionfisica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author FSN-Desarrollo
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findAll(String namedQueryName) {
        return getEntityManager().createNamedQuery(namedQueryName).getResultList();
    }
    
    public void updateActivo(String namedQueryName, Empleado par1, String par2, Ubicacionfisica par3) {
         getEntityManager().createNamedQuery(namedQueryName).setParameter("emp",par1).setParameter("act", par2).setParameter("ubi", par3).executeUpdate();
         
    }

    public List<T> findAllbyone(String namedQueryName, String estado) {
        return getEntityManager().createNamedQuery(namedQueryName)
                .setParameter(estado, '0')
                .getResultList();
    }
    public List<T> findAllbyone(String namedQueryName, String campoBusqueda, Integer valorCompara) {
        return getEntityManager().createNamedQuery(namedQueryName)
                .setParameter("iddpto", valorCompara)
                .getResultList();
    }

    public List<T> findAllbyone(String estado) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<T> c = cq.from(entityClass);
        cq.select(c);
        cq.where(cb.notEqual((c.get(estado)), '0'));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
}
