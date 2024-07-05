import DAO.CursoDAO;
import org.example.Curso;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CursoDAOTest {
    private CursoDAO cursoDAO;
    private Curso curso;

    @Before
    public void setUp() {
        cursoDAO = new CursoDAO();
        curso = new Curso();
        curso.setNome("Teste org.exampleCurso");
        cursoDAO.insert(curso);
    }

    @After
    public void tearDown() {
        cursoDAO.delete(curso.getId());
    }

    @Test
    public void testInsert() {
        Curso insertedCurso = cursoDAO.get(curso.getId());
        assertNotNull(insertedCurso);
    }

    @Test
    public void testList() {
        assertTrue(cursoDAO.list().size() > 0);
    }

    @Test
    public void testUpdate() {
        curso.setNome("Updated Nome");
        cursoDAO.update(curso);
        Curso updatedCurso = cursoDAO.get(curso.getId());
        assertEquals("Updated Nome", updatedCurso.getNome());
    }

    @Test
    public void testDelete() {
        cursoDAO.delete(curso.getId());
        Curso deletedCurso = cursoDAO.get(curso.getId());
        assertNull(deletedCurso);
    }
}
