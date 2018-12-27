package com.katariasoft.technologies.jpaHibernate.college.data.utils;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class QueryExecutor {

	@PersistenceContext
	private EntityManager em;

	public <T> List<T> fetchList(String queryName, Map<String, Object> queryParams, Class<T> clazz) {
		try {
			TypedQuery<T> typedQuery = em.createNamedQuery(queryName, clazz);
			if (Objects.nonNull(queryParams))
				queryParams.forEach((key, value) -> typedQuery.setParameter(key, value));
			return typedQuery.getResultList();
		} catch (Exception e) {
			throw e;
		}
	}

	public <T> T fetchValue(String queryName, Map<String, Object> queryParams, Class<T> clazz) {
		try {
			TypedQuery<T> typedQuery = em.createNamedQuery(queryName, clazz);
			if (Objects.nonNull(queryParams))
				queryParams.forEach((key, value) -> typedQuery.setParameter(key, value));
			return typedQuery.getSingleResult();
		} catch (Exception e) {
			throw e;
		}
	}

}
