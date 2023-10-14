package pos.hibernate.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	
	public static EntityManagerFactory factory=null;
	//Utilizando static para que chame apenas uma vez, é uma classe para o hibernate conectar ao persistence
	static {
		init();
	}
	
	private static void init() {
		try {
			if(factory == null) {
				factory=Persistence.createEntityManagerFactory("pos");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// metodo public porque é através dele que vou utilizar operações de crud , provendo a persistência
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	public static Object getPrimaryKey(Object entity) { // vou identificar o id
		return factory.getPersistenceUnitUtil().getIdentifier(entity);
	}
}
