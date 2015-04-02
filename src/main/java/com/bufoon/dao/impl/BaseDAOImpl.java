package com.bufoon.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bufoon.dao.BaseDAO;

@Repository("baseDAO")  
@SuppressWarnings("all") 
public class BaseDAOImpl<T> implements BaseDAO<T> {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Serializable save(T o) {
		return this.getCurrentSession().save(o);
	}

	public void delete(T o) {
		this.getCurrentSession().delete(o);
	}

	public void update(T o) {
		this.getCurrentSession().update(o);
	}

	public void saveOrUpdate(T o) {
		this.getCurrentSession().saveOrUpdate(o);
	}

	public List<T> find(String hql) {
		return this.getCurrentSession().createQuery(hql).list();
	}

	public List<T> find(String hql, Object[] param) {
		Query query = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for(int i = 0; i < param.length; i++) {
				query.setParameter(i, param[i]);
			}
		}
		return query.list();
	}

	public List<T> find(String hql, List<Object> param) {
		Query query = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				query.setParameter(i, param.get(i));
			}
		}
		return query.list();
	}

	public List<T> find(String hql, List<Object> param, Integer page,
			Integer pageSize) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (pageSize == null || pageSize < 1) {
			pageSize = 10;
		}
		
		Query query = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				query.setParameter(i, param.get(i));
			}
		}
		return query.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize).list() ;
	}

	public T get(Class<T> c, Serializable id) {
		return (T)this.getCurrentSession().get(c, id);
	}

	public T get(String hql, List<Object> param) {
		List<T> list = this.find(hql, param);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public Long count(String hql, Object[] param) {
		Query query = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				query.setParameter(i, param[i]);
			}
		}
		return (Long) query.uniqueResult();
	}

	public Long count(String hql, List<Object> param) {
		Query query = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				query.setParameter(i, param.get(i));
			}
		}
		return (Long) query.uniqueResult();
	}

	public Integer executeHql(String hql) {
		return this.getCurrentSession().createQuery(hql).executeUpdate();
	}

	public Integer executeHql(String hql, Object[] param) {
		Query query = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				query.setParameter(i, param[i]);
			}
		}
		return query.executeUpdate();
	}

	public Integer executeHql(String hql, List<Object> param) {
		Query query = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				query.setParameter(i, param.size());
			}
		}
		return query.executeUpdate();
	}

	public List<T> find(String hql, Object[] param, Integer page,
			Integer pageSize) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (pageSize == null || pageSize < 1) {
			pageSize = 10;
		}
		
		Query query = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				query.setParameter(i, param[i]);
			}
		}
		return query.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize).list() ;
	}

	public T get(String hql, Object[] param) {
		List<T> l = this.find(hql, param);  
        if (l != null && l.size() > 0) {  
            return l.get(0);  
        } else {  
            return null;  
        }  
	}

}
