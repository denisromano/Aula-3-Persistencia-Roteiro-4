package br.com.fiap.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Forum;
import br.com.fiap.entity.Usuario;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("Aula3_JPA");
		
		EntityManager em = entityManagerFactory.
				createEntityManager();
		
		ForumHelper fHelper = new ForumHelper(em);
		
		Forum forum = new Forum();
		forum.setAssunto("Java Persistence");
		forum.setDescricao("Discussão de JPA");
			
		System.out.println(fHelper.salvar(forum));
		
		Usuario usuario = new Usuario();
		usuario.setNome("testeUsuario");
		usuario.setEmail("teste@teste.com");		
		
		System.out.println(fHelper.adicionarUsuario(forum.getId(), usuario));
	}

}
