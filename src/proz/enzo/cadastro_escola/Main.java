package proz.enzo.cadastro_escola;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Professor> professores = new ArrayList<>();
    private static ArrayList<Aluno> alunos = new ArrayList<>();
    private static ArrayList<Turma> turmas = new ArrayList<>();
    private static ArrayList<Disciplina> disciplinas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Digite a opção desejada:");
            System.out.println("1. Cadastrar Professor");
            System.out.println("2. Cadastrar Aluno");
            System.out.println("3. Cadastrar Turma");
            System.out.println("4. Cadastrar Disciplina");
            System.out.println("5. Listar Professores");
            System.out.println("6. Listar Alunos");
            System.out.println("7. Listar Turmas");
            System.out.println("8. Listar Disciplinas");
            System.out.println("9. Sair");
            
            int opcao = sc.nextInt();
            sc.nextLine(); // Consumir a nova linha
            
            switch (opcao) {
                case 1:
                    cadastrarProfessor(sc);
                    break;
                case 2:
                    cadastrarAluno(sc);
                    break;
                case 3:
                    cadastrarTurma(sc);
                    break;
                case 4:
                    cadastrarDisciplina(sc);
                    break;
                case 5:
                    listarProfessores();
                    break;
                case 6:
                    listarAlunos();
                    break;
                case 7:
                    listarTurmas();
                    break;
                case 8:
                    listarDisciplinas();
                    break;
                case 9:
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    private static void cadastrarProfessor(Scanner sc) {
        System.out.println("Digite o nome do professor:");
        String nome = sc.nextLine();
        System.out.println("Digite o CPF do professor:");
        String cpf = sc.nextLine();
        System.out.println("Digite a matrícula do professor:");
        String matricula = sc.nextLine();
        System.out.println("Digite o MASP do professor:");
        String masp = sc.nextLine();
        System.out.println("Digite a idade do professor:");
        String idade = sc.nextLine();
        System.out.println("Digite o CEP do professor:");
        String cep = sc.nextLine();
        System.out.println("Digite o gênero do professor:");
        String genero = sc.nextLine();
        
        professores.add(new Professor(nome, cpf, matricula, masp, idade, cep, genero));
        System.out.println("Professor cadastrado com sucesso!");
    }

    private static void cadastrarAluno(Scanner sc) {
        System.out.println("Digite o nome do aluno:");
        String nome = sc.nextLine();
        System.out.println("Digite o CPF do aluno:");
        String cpf = sc.nextLine();
        System.out.println("Digite a matrícula do aluno:");
        String matricula = sc.nextLine();
        System.out.println("Digite a idade do aluno:");
        String idade = sc.nextLine();
        System.out.println("Digite o CEP do aluno:");
        String cep = sc.nextLine();
        System.out.println("Digite o gênero do aluno:");
        String genero = sc.nextLine();
        
        alunos.add(new Aluno(nome, cpf, idade, matricula, cep, genero));
        System.out.println("Aluno cadastrado com sucesso!");
    }

    private static void cadastrarTurma(Scanner sc) {
        System.out.println("Digite o nome da turma:");
        String nomeTurma = sc.nextLine();
        Turma turma = new Turma(nomeTurma);

        System.out.println("Deseja adicionar professores à turma? (s/n)");
        String addProfessores = sc.nextLine();
        while (addProfessores.equalsIgnoreCase("s")) {
            System.out.println("Digite a matrícula do professor a ser adicionado:");
            String matriculaProfessor = sc.nextLine();
            Professor professor = buscarProfessorPorMatricula(matriculaProfessor);
            if (professor != null) {
                turma.adicionarProfessor(professor);
                System.out.println("Professor adicionado!");
            } else {
                System.out.println("Professor não encontrado!");
            }
            System.out.println("Deseja adicionar mais professores? (s/n)");
            addProfessores = sc.nextLine();
        }

        System.out.println("Deseja adicionar alunos à turma? (s/n)");
        String addAlunos = sc.nextLine();
        while (addAlunos.equalsIgnoreCase("s")) {
            System.out.println("Digite o CPF do aluno a ser adicionado:");
            String cpfAluno = sc.nextLine();
            Aluno aluno = buscarAlunoPorCpf(cpfAluno);
            if (aluno != null) {
                turma.adicionarAlunos(aluno);
                System.out.println("Aluno adicionado!");
            } else {
                System.out.println("Aluno não encontrado!");
            }
            System.out.println("Deseja adicionar mais alunos? (s/n)");
            addAlunos = sc.nextLine();
        }

        turmas.add(turma);
        System.out.println("Turma cadastrada com sucesso!");
    }

    private static void cadastrarDisciplina(Scanner sc) {
        System.out.println("Digite a primeira disciplina:");
        String nomeDisciplina = sc.nextLine();
        
        
        disciplinas.add(new Disciplina(nomeDisciplina));
        System.out.println("Disciplina cadastrada com sucesso!");
    }

    private static Professor buscarProfessorPorMatricula(String matricula) {
        for (Professor professor : professores) {
            if (professor.getMatricula().equals(matricula)) {
                return professor;
            }
        }
        return null;
    }

    private static Aluno buscarAlunoPorCpf(String cpf) {
        for (Aluno aluno : alunos) {
            if (aluno.getCpf().equals(cpf)) {
                return aluno;
            }
        }
        return null;
    }

    private static void listarProfessores() {
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
        } else {
            for (Professor professor : professores) {
                professor.printInformacaoProfessor();
            }
        }
    }

    private static void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Aluno aluno : alunos) {
                aluno.exibir();
            }
        }
    }

    private static void listarTurmas() {
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
        } else {
            for (Turma turma : turmas) {
                turma.listarProfessores();
                turma.listarAlunos();
            }
        }
    }

    private static void listarDisciplinas() {
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma Disciplina cadastrada.");
        } else {
            for (Disciplina Disciplina : disciplinas) {
                Disciplina.exibir();
            }
        }
    }
}
