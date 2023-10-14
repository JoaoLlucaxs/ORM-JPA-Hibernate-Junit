package pos.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import pos.hibernate.util.HibernateUtil;

public class DaoGeneric<E> {
	
	private EntityManager entityManager=HibernateUtil.getEntityManager();
	
	public void salvar(E entidade) {
		EntityTransaction transaction= entityManager.getTransaction(); 
		transaction.begin(); // estou iniciando o processo
		
		entityManager.persist(entidade);
		transaction.commit(); // salvei no banco
	}
	
	public E updateMerge(E entidade) {  // salva ou atualiza
		EntityTransaction transaction= entityManager.getTransaction(); 
		transaction.begin(); 
		
		E entidadeSalva=entityManager.merge(entidade);
		transaction.commit(); 
		return entidadeSalva;
	}

	// A seguir duas maneiras
	@SuppressWarnings("unchecked")
	public E pesquisar(E entidade) { // pelo id
		Object id=HibernateUtil.getPrimaryKey(entidade);
		E e=(E) entityManager.find(entidade.getClass(),id);
		return e;
	}
	
	@SuppressWarnings("unchecked")
	public E pesquisar(Long id,Class<E> entidade) { // pelo id
		E e=(E) entityManager.find(entidade,id);
		return e;
	}
	
	public void deletarPorId(E entidade) {
		Object id=HibernateUtil.getPrimaryKey(entidade);
		
		EntityTransaction transaction= entityManager.getTransaction();
		transaction.begin();
		
		entityManager.createNativeQuery("delete from " + entidade.getClass().getSimpleName().toLowerCase() 
				+ " where id =" + id).executeUpdate(); //fazendo o delete
		
		transaction.commit(); //gravando a alteração
	}
}
