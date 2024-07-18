/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrodetareas.persistencia;


import com.mycompany.registrodetareas.logica.Electrodomestico;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class ElectrodomesticoJpaController implements Serializable {
    
     public ElectrodomesticoJpaController(EntityManagerFactory emf) {
    this.emf = emf;
    }
    
    private EntityManagerFactory emf = null;

    public ElectrodomesticoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("RegistroDeTareasPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Electrodomestico electrodomestico) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(electrodomestico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Electrodomestico electrodomestico) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            electrodomestico = em.merge(electrodomestico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Electrodomestico electrodomestico;
            try {
                electrodomestico = em.getReference(Electrodomestico.class, id);
                electrodomestico.getNum_cliente();
            } catch (Exception e) {
                throw new Exception("El electrodoméstico con el id " + id + " no existe.", e);
            }
            em.remove(electrodomestico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Electrodomestico> findElectrodomesticoEntities() {
        return findElectrodomesticoEntities(true, -1, -1);
    }

    public List<Electrodomestico> findElectrodomesticoEntities(int maxResults, int firstResult) {
        return findElectrodomesticoEntities(false, maxResults, firstResult);
    }

    private List<Electrodomestico> findElectrodomesticoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Electrodomestico> cq = em.getCriteriaBuilder().createQuery(Electrodomestico.class);
            cq.select(cq.from(Electrodomestico.class));
            javax.persistence.Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Electrodomestico findElectrodomestico(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Electrodomestico.class, id);
        } finally {
            em.close();
        }
    }

    public int getElectrodomesticoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Long> cq = em.getCriteriaBuilder().createQuery(Long.class);
            Root<Electrodomestico> rt = cq.from(Electrodomestico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            javax.persistence.Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}

