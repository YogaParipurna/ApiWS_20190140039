/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BagasiHidroponik.Bagasi.Hidroponik;

import com.BagasiHidroponik.Bagasi.Hidroponik.exceptions.NonexistentEntityException;
import com.BagasiHidroponik.Bagasi.Hidroponik.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Yapart
 */
public class TanamJpaController implements Serializable {

    public TanamJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.BagasiHidroponik_Bagasi-Hidroponik_jar_0.0.1-SNAPSHOTPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public TanamJpaController() {
    }
    
    

    public void create(Tanam tanam) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tanam);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTanam(tanam.getKodeTanam()) != null) {
                throw new PreexistingEntityException("Tanam " + tanam + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tanam tanam) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tanam = em.merge(tanam);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tanam.getKodeTanam();
                if (findTanam(id) == null) {
                    throw new NonexistentEntityException("The tanam with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tanam tanam;
            try {
                tanam = em.getReference(Tanam.class, id);
                tanam.getKodeTanam();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tanam with id " + id + " no longer exists.", enfe);
            }
            em.remove(tanam);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tanam> findTanamEntities() {
        return findTanamEntities(true, -1, -1);
    }

    public List<Tanam> findTanamEntities(int maxResults, int firstResult) {
        return findTanamEntities(false, maxResults, firstResult);
    }

    private List<Tanam> findTanamEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tanam.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Tanam findTanam(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tanam.class, id);
        } finally {
            em.close();
        }
    }

    public int getTanamCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tanam> rt = cq.from(Tanam.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
