package proz.enzo.cadastro_escola;

import java.util.ArrayList;
import java.util.Scanner;

public class Interligar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Professor> professores = new ArrayList<>();
        ArrayList<Aluno> alunos = new ArrayList<>();
        ArrayList<Turma> turmas = new ArrayList<>();

        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar novo professor");
            System.out.println("2. Cadastrar novo aluno");
            System.out.println("3. Criar nova turma");
            System.out.println("4. Adicionar professor a uma turma");
            System.out.println("5. Adicionar aluno a uma turma");
            System.out.println("6. Listar professores de uma turma");
            System.out.println("7. Listar alunos de uma turma");
            System.out.println("8. Sair");
            int opcao = sc.nextInt();
            sc.nextLine();  // Consome a nova linha

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do professor:");
                    String nomeProfessor = sc.nextLine();
                    System.out.println("Digite o CPF do professor:");
                    String cpfProfessor = sc.nextLine();
                    System.out.println("Digite a matrícula do professor:");
                    String matriculaProfessor = sc.nextLine();
                    System.out.println("Digite o MASP do professor:");
                    String maspProfessor = sc.nextLine();
                    System.out.println("Digite a idade do professor:");
                    String idadeProfessor = sc.nextLine();
                    System.out.println("Digite o CEP do professor:");
                    String cepProfessor = sc.nextLine();
                    System.out.println("Digite o gênero do professor:");
                    String generoProfessor = sc.nextLine();
                    professores.add(new Professor(nomeProfessor, cpfProfessor, matriculaProfessor, maspProfessor, idadeProfessor, cepProfessor, generoProfessor));
                    break;

                case 2:
                    System.out.println("Digite o nome do aluno:");
                    String nomeAluno = sc.nextLine();
                    System.out.println("Digite o CPF do aluno:");
                    String cpfAluno = sc.nextLine();
                    System.out.println("Digite a matrícula do aluno:");
                    String matriculaAluno = sc.nextLine();
                    System.out.println("Digite a idade do aluno:");
                    String idadeAluno = sc.nextLine();
                    System.out.println("Digite o CEP do aluno:");
                    String cepAluno = sc.nextLine();
                    System.out.println("Digite o gênero do aluno:");
                    String generoAluno = sc.nextLine();
                    alunos.add(new Aluno(nomeAluno, cpfAluno, idadeAluno, matriculaAluno, cepAluno, generoAluno));
                    break;

                case 3:
                    System.out.println("Digite o nome da turma:");
                    String nomeTurma = sc.nextLine();
                    turmas.add(new Turma(nomeTurma));
                    break;

                case 4:
                    System.out.println("Digite o nome da turma:");
                    String nomeTurmaProfessor = sc.nextLine();
                    System.out.println("Digite a matrícula do professor:");
                    String matriculaTurmaProfessor = sc.nextLine();
                    Turma turmaProf = buscarTurma(turmas, nomeTurmaProfessor);
                    Professor professor = buscarProfessor(professores, matriculaTurmaProfessor);
                    if (turmaProf != null && professor != null) {
                        turmaProf.adicionarProfessor(professor);
                    } else {
                        System.out.println("Turma ou professor não encontrados.");
                    }
                    break;

                case 5:
                    System.out.println("Digite o nome da turma:");
                    String nomeTurmaAluno = sc.nextLine();
                    System.out.println("Digite a matrícula do aluno:");
                    String matriculaTurmaAluno = sc.nextLine();
                    Turma turmaAluno = buscarTurma(turmas, nomeTurmaAluno);
                    Aluno aluno = buscarAluno(alunos, matriculaTurmaAluno);
                    if (turmaAluno != null && aluno != null) {
                        turmaAluno.adicionarAlunos(aluno);
                    } else {
                        System.out.println("Turma ou aluno não encontrados.");
                    }
                    break;

                case 6:
                    System.out.println("Digite o nome da turma:");
                    String nomeTurmaListarProfessores = sc.nextLine();
                    Turma turmaListarProfessores = buscarTurma(turmas, nomeTurmaListarProfessores);
                    if (turmaListarProfessores != null) {
                        turmaListarProfessores.listarProfessores();
                    } else {
                        System.out.println("Turma não encontrada.");
                    }
                    break;

                case 7:
                    System.out.println("Digite o nome da turma:");
                    String nomeTurmaListarAlunos = sc.nextLine();
                    Turma turmaListarAlunos = buscarTurma(turmas, nomeTurmaListarAlunos);
                    if (turmaListarAlunos != null) {
                        turmaListarAlunos.listarAlunos();
                    } else {
                        System.out.println("Turma não encontrada.");
                    }
                    break;

                case 8:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        sc.close();
    }

    private static Turma buscarTurma(ArrayList<Turma> turmas, String nomeTurma) {
        for (Turma turma : turmas) {
            if (turma.getNometurma().equals(nomeTurma)) {
                return turma;
            }
        }
        return null;
    }

    private static Professor buscarProfessor(ArrayList<Professor> professores, String matricula) {
        for (Professor professor : professores) {
            if (professor.getMatricula().equals(matricula)) {
                return professor;
            }
        }
        return null;
    }

    private static Aluno buscarAluno(ArrayList<Aluno> alunos, String matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }
        }
        return null;
    }
}
