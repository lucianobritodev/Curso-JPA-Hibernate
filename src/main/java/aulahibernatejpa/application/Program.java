package aulahibernatejpa.application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import aulahibernatejpa.entities.Pessoa;

public class Program {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		/* Entidades que serão salvas na base de dados
		 */ 
		 Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		 Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
		 Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
		
		/* Salvando entidades no banco
		 */ 
		 em.getTransaction().begin(); // inicia uma transação
		 em.persist(p1); em.persist(p2);
		 em.persist(p3);
		 em.getTransaction().commit(); // finaliza a transação
		  
		
		/* Buscando entidades no banco 
		 */
		Pessoa p = em.find(Pessoa.class, 2);
		System.out.println(p);
		
		System.out.println("Pronto!");
		
		em.close();
		emf.close();

	}

}
