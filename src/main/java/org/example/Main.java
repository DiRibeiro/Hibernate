package org.example;

import DAO.AlunoDAO;
import DAO.CursoDAO;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static AlunoDAO alunoDAO = new AlunoDAO();
    private static CursoDAO cursoDAO = new CursoDAO();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Inserir Aluno");
            System.out.println("2. Listar Alunos");
            System.out.println("3. Deletar Aluno");
            System.out.println("4. Atualizar Aluno");
            System.out.println("5. Inserir Curso");
            System.out.println("6. Listar Cursos");
            System.out.println("7. Deletar Curso");
            System.out.println("8. Atualizar Curso");
            System.out.println("0. Sair");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nome do Aluno: ");
                    String nomeAluno = scanner.nextLine();
                    Aluno aluno = new Aluno();
                    aluno.setNome(nomeAluno);
                    alunoDAO.insert(aluno);
                    break;
                case 2:
                    List<Aluno> alunos = alunoDAO.list();
                    alunos.forEach(a -> System.out.println(a.getId() + ": " + a.getNome()));
                    break;
                case 3:
                    System.out.print("ID do Aluno: ");
                    Long idAluno = scanner.nextLong();
                    alunoDAO.delete(idAluno);
                    break;
                case 4:
                    System.out.print("ID do Aluno: ");
                    Long idAlunoUpdate = scanner.nextLong();
                    scanner.nextLine();
                    Aluno alunoUpdate = alunoDAO.get(idAlunoUpdate);
                    if (alunoUpdate != null) {
                        System.out.print("Novo Nome: ");
                        String novoNome = scanner.nextLine();
                        alunoUpdate.setNome(novoNome);
                        alunoDAO.update(alunoUpdate);
                    }
                    break;
                case 5:
                    System.out.print("Nome do Curso: ");
                    String nomeCurso = scanner.nextLine();
                    Curso curso = new Curso();
                    curso.setNome(nomeCurso);
                    cursoDAO.insert(curso);
                    break;
                case 6:
                    List<Curso> cursos = cursoDAO.list();
                    cursos.forEach(c -> System.out.println(c.getId() + ": " + c.getNome()));
                    break;
                case 7:
                    System.out.print("ID do Curso: ");
                    Long idCurso = scanner.nextLong();
                    cursoDAO.delete(idCurso);
                    break;
                case 8:
                    System.out.print("ID do Curso: ");
                    Long idCursoUpdate = scanner.nextLong();
                    scanner.nextLine();
                    Curso cursoUpdate = cursoDAO.get(idCursoUpdate);
                    if (cursoUpdate != null) {
                        System.out.print("Novo Nome: ");
                        String novoNomeCurso = scanner.nextLine();
                        cursoUpdate.setNome(novoNomeCurso);
                        cursoDAO.update(cursoUpdate);
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
