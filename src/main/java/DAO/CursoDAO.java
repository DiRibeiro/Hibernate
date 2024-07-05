package DAO;

import org.example.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CursoDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");

    public void insert(Curso curso) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(curso);
        em.getTransaction().commit();
        em.close();
    }

    public Curso get(Long id) {
        EntityManager em = emf.createEntityManager();
        Curso curso = em.find(Curso.class, id);
        em.close();
        return curso;
    }

    public List<Curso> list() {
        EntityManager em = emf.createEntityManager();
        List<Curso> cursos = em.createQuery("from Curso", Curso.class).getResultList();
        em.close();
        return cursos;
    }

    public void update(Curso curso) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(curso);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Curso curso = em.find(Curso.class, id);
        em.remove(curso);
        em.getTransaction().commit();
        em.close();
    }
}
