package it.unibas.centrobenessere.persistenza.hibernate;

import it.unibas.centrobenessere.persistenza.DAOException;
import it.unibas.centrobenessere.persistenza.IDAOGenerico;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

public class DAOGenericoHibernate<T> implements IDAOGenerico<T> {

    private static Log logger = LogFactory.getLog(DAOGenericoHibernate.class);

    private Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public DAOGenericoHibernate(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    protected Class<T> getPersistentClass() {
        System.out.println("Persistent class: " + persistentClass.getName());
        return persistentClass;
    }

    protected static Session getSession() throws DAOException {
        try {
            return DAOUtilHibernate.getCurrentSession();
        } catch (HibernateException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
    }

    @SuppressWarnings("unchecked")
    public T makePersistent(T entity) throws DAOException {
        try {
            getSession().saveOrUpdate(entity);
        } catch (HibernateException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
        return entity;
    }

    public void makeTransient(T entity) throws DAOException {
        try {
            getSession().delete(entity);
        } catch (HibernateException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
    }

    @SuppressWarnings("unchecked")
    public void lock(T entity) throws DAOException {
        try {
            getSession().lock(entity, LockMode.UPGRADE);
        } catch (HibernateException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
    }

    @SuppressWarnings("unchecked")
    public T findById(Long id, boolean lock) throws DAOException {
        T entity;
        try {
            if (lock) {
                entity = (T) getSession().load(getPersistentClass(), id, LockMode.UPGRADE);
            } else {
                entity = (T) getSession().load(getPersistentClass(), id);
            }
        } catch (HibernateException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
        return entity;
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() throws DAOException {
        return findByCriteria();
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll(int offset, int limite) throws DAOException {
        return findByCriteria(offset, limite);
    }

    @SuppressWarnings("unchecked")
    public List<T> findByCriteria(Criterion... criterion) throws DAOException {
        try {
            Criteria crit = getSession().createCriteria(getPersistentClass());
            for (Criterion c : criterion) {
                crit.add(c);
            }
            return crit.list();
        } catch (HibernateException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> findByCriteria(int offset, int limite, Criterion... criterion) throws DAOException {
        try {
            Criteria crit = getSession().createCriteria(getPersistentClass());
            for (Criterion c : criterion) {
                crit.add(c);
            }
            crit.setFirstResult(offset);
            crit.setMaxResults(limite);
            return crit.list();
        } catch (HibernateException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
    }
}