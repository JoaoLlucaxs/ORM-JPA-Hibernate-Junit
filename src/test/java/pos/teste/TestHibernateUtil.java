package pos.teste;

import org.junit.Test;

import pos.dao.DaoGeneric;
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
		
		UsuarioPessoa user=dao.pesquisar(5L,UsuarioPessoa.class);
		
		
		dao.deletarPorId(user);
		
		System.out.println(user);
	}
}
