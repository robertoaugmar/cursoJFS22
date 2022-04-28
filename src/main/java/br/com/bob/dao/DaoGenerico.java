package br.com.bob.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.bob.entidades.Pessoa;
import br.com.bob.jpautil.JPAUtil;

public class DaoGenerico<T> {

	public void salvar(T tabela) {

		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		em.persist(tabela);

		et.commit();
		em.close();

	}

	public T merge(T tabela) {

		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		T ret = em.merge(tabela);

		et.commit();
		em.close();
		
		return ret;

	}
	
	public void delete(T tabela) {

		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();

		Pessoa p = (Pessoa) tabela ;
		et.begin();
		
		//em.find( p , p.getId());

		//em.remove(tabela);
		
		em.remove(em.merge(tabela));

		et.commit();
		em.close();

	}
	
	public void deletePorId(T tabela) {

		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Object id = JPAUtil.getPrimaryKey(tabela);
		em.createQuery("delete from " + tabela.getClass().getCanonicalName() + " where id = " + id ).executeUpdate();

		et.commit();
		em.close();

	}
	
	public List<T> getListEntity(Class<T> tabela) {

		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();

		//et.begin();

		List<T> ret = em.createQuery(" from " + tabela.getName()).getResultList();
		
		//et.commit();
		em.close();
		
		return ret;
	}



}
