package br.com.interfile.interflow.core.commons.util;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class PersistenceManager implements Serializable {

	private static final long serialVersionUID = 1L;
	private final static String UNIT_NAME =  "interflow-persistence-unit";
	
	
	@PersistenceContext(unitName=UNIT_NAME, name=UNIT_NAME)
	protected EntityManager em;

	   /**
     * persist 
     * @param object
     * @return
     * @throws Exception 
     */
    public Object persist(Object object) throws Exception {
        em.persist(object);
        em.flush();
        return object;
    }

    /**
     * Remove
     * @param object 
     */
    public void remove(Object object) {
        em.remove(object);
    }

    /**
     * refresh
     * @param object 
     */
    public void refresh(Object object) {
        em.refresh(object);
    }

    /**
     * Merge
     * @param object
     * @return
     * @throws Exception 
     */
    public Object merge(Object object) throws Exception {
        em.merge(object);
        em.flush();
        return object;
    }

    /**
     * Find
     * @param query
     * @return 
     */
    @SuppressWarnings("unchecked")
	public List<Object> find(final String query) {
        return em.createQuery(query).getResultList();
    }

    /**
     * Find
     * @param query
     * @param first
     * @param max
     * @return 
     */
    @SuppressWarnings("unchecked")
	public List<Object> find(final String query, int first, int max) {
        Query createQuery = em.createQuery(query);
        createQuery.setFirstResult(first);
        createQuery.setMaxResults(max);
        return createQuery.getResultList();
    }

    /**
     * Find
     * @param query
     * @param maxResults
     * @return 
     */
    @SuppressWarnings("unchecked")
	public List<Object> find(final String query, int maxResults) {
        Query createQuery = em.createQuery(query);
        createQuery.setMaxResults(maxResults);
        return createQuery.getResultList();
    }    
    
    /**
     * Find count
     * @param query
     * @return 
     */
    public int findCount(final String query) {
        return ((Number)em.createQuery(query).getSingleResult()).intValue();
    }      
}
