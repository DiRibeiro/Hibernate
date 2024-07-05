import DAO.AlunoDAO;
import org.example.Aluno;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlunoDAOTest {
    private AlunoDAO alunoDAO;
    private Aluno aluno;

    @Before
    public void setUp() {
        alunoDAO = new AlunoDAO();
        aluno = new Aluno();
        aluno.setNome("Teste Aluno");
        alunoDAO.insert(aluno);
    }

    @After
    public void tearDown() {
        alunoDAO.delete(aluno.getId());
    }

    @Test
    public void testInsert() {
        Aluno insertedAluno = alunoDAO.get(aluno.getId());
        assertNotNull(insertedAluno);
    }

    @Test
    public void testList() {
        assertTrue(alunoDAO.list().size() > 0);
    }

    @Test
    public void testUpdate() {
        aluno.setNome("Updated Nome");
        alunoDAO.update(aluno);
        Aluno updatedAluno = alunoDAO.get(aluno.getId());
        assertEquals("Updated Nome", updatedAluno.getNome());
    }

    @Test
    public void testDelete() {
        alunoDAO.delete(aluno.getId());
        Aluno deletedAluno = alunoDAO.get(aluno.getId());
        assertNull(deletedAluno);
    }
}
