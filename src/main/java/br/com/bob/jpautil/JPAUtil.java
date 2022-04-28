package br.com.bob.jpautil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory;

	static {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("cursoJSF22");
		}
	}

	public static EntityManager getEntityManager() {

		return factory.createEntityManager();
	}

	public static Object getPrimaryKey(Object entity ) {

		return factory.getPersistenceUnitUtil().getIdentifier(entity);
	}

}
