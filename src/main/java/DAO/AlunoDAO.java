package DAO;

import org.example.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AlunoDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");

    public void insert(Aluno aluno) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(aluno);
        em.getTransaction().commit();
        em.close();
    }

    public Aluno get(Long id) {
        EntityManager em = emf.createEntityManager();
        Aluno aluno = em.find(Aluno.class, id);
        em.close();
        return aluno;
    }

    public List<Aluno> list() {
        EntityManager em = emf.createEntityManager();
        List<Aluno> alunos = em.createQuery("from Aluno", Aluno.class).getResultList();
        em.close();
        return alunos;
    }

    public void update(Aluno aluno) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(aluno);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Aluno aluno = em.find(Aluno.class, id);
        em.remove(aluno);
        em.getTransaction().commit();
        em.close();
    }
}
