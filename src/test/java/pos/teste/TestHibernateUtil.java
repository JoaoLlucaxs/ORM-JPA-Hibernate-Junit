package pos.teste;

import java.util.List;

import org.junit.Test;

import pos.dao.DaoGeneric;
import pos.model.TelefoneUser;
import pos.model.UsuarioPessoa;

public class TestHibernateUtil {
	
	@Test
	public void testeHibernateUtil() {
		DaoGeneric<UsuarioPessoa> dao=new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa user=new UsuarioPessoa();
		
		user.setLogin("Teste");
		user.setEmail("java@gmail.com");
		user.setNome("Luck");
		user.setSobrenome("Queiroz");
		user.setSenha("12344");
		
		dao.salvar(user);
	}
	
	@Test
	public void testeBuscar() {
		DaoGeneric<UsuarioPessoa> dao=new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa user=new UsuarioPessoa();
		user.setId(2L);
		
		user=dao.pesquisar(user);
		System.out.println(user);
	}
	
	@Test
	public void testeBusca2() {
		DaoGeneric<UsuarioPessoa> dao=new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa user=dao.pesquisar(2L,UsuarioPessoa.class);
		
		System.out.println(user);
	}
	
	@Test
	public void testeUpdate() {
		DaoGeneric<UsuarioPessoa> dao=new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa user=dao.pesquisar(2L,UsuarioPessoa.class);
		
		user.setNome("Frederico");
		user.setSobrenome("Ribeiro");
		
		user=dao.updateMerge(user);
		
		System.out.println(user);
	}
	
	@Test
	public void testeDelete() {
		DaoGeneric<UsuarioPessoa> dao=new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa user=dao.pesquisar(1L,UsuarioPessoa.class);
		
		
		dao.deletarPorId(user);
		
		System.out.println(user);
	}
	
	@Test
	public void testeLista() {
		DaoGeneric<UsuarioPessoa> dao=new DaoGeneric<UsuarioPessoa>();
		
		List<UsuarioPessoa> usuario=dao.lista(UsuarioPessoa.class);
		
		for (UsuarioPessoa usuarioPessoa : usuario) {
			System.out.println(usuarioPessoa);
			System.out.println("==========================");
		}
	}
	
	
	// criando query especificas
	@Test
	public void testQuery() {
		DaoGeneric<UsuarioPessoa> dao=new DaoGeneric<UsuarioPessoa>();
		
		List<UsuarioPessoa> usuario=dao.getEntityManager().createQuery(" from UsuarioPessoa").getResultList();
		
		for (UsuarioPessoa usuarioPessoa : usuario) {
			System.out.println(usuarioPessoa);
		}
		
	}
	// limitando para trazer apenas os 4 primerios
	@Test
	public void testQueryMaxLimit() {
		DaoGeneric<UsuarioPessoa> dao=new DaoGeneric<UsuarioPessoa>();
		
		List<UsuarioPessoa> usuario=dao.getEntityManager().createQuery(" from UsuarioPessoa order by nome")
				.setMaxResults(4)
				.getResultList();
		
		for (UsuarioPessoa usuarioPessoa : usuario) {
			System.out.println(usuarioPessoa);
		}
		
	}
	
	@Test
	public void testeQueryPorParametro() {
		DaoGeneric<UsuarioPessoa> dao=new DaoGeneric<UsuarioPessoa>();
		
		List<UsuarioPessoa> usuario=dao.getEntityManager().createQuery(" from UsuarioPessoa where nome= :nome")
				.setParameter("nome", "Frederico").getResultList();
	}
	
	@Test
	public void testeNameQuery() {
		DaoGeneric<UsuarioPessoa> dao=new DaoGeneric<UsuarioPessoa>();
		
		List<UsuarioPessoa> usuario=dao.getEntityManager().createNamedQuery("UsuarioPessoa.consultarTodos")
				.getResultList();
		
		for (UsuarioPessoa usuarioPessoa : usuario) {
			System.out.println(usuarioPessoa);
		}
	}
	
	@Test
	public void inserindoTel() {
		DaoGeneric dao=new DaoGeneric();
		
		UsuarioPessoa pessoa= (UsuarioPessoa) dao.pesquisar(2L,UsuarioPessoa.class);
		
		TelefoneUser telefone=new TelefoneUser();
		telefone.setTipo("celular");
		telefone.setNumero("753535454");
		telefone.setUsuariopessoa(pessoa);
		
		dao.salvar(telefone);
		
	}
	
}
