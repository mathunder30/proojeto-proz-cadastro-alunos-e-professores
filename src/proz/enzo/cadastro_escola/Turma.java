package proz.enzo.cadastro_escola;
import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String nometurma;
    private List<Professor> professores;
    private List<Aluno> alunos;

    public Turma(String nometurma){
        this.nometurma = nometurma;
        this.professores = new ArrayList<>();
        this.alunos = new ArrayList<>();
    }
    public void adicionarProfessor(Professor professor){
        professores.add(professor);
    }
    public void adicionarAlunos(Aluno aluno){
        alunos.add(aluno);
    }
    public void listarProfessores(){
        System.out.println("Professores da turma "+ nometurma+ ":");
        for (Professor professor : professores) {
            System.out.println("Matricula: "+ professor.getMatricula() + ", Nome: "+ professor.getNome());
            
        }
    }
    public void listarAlunos(){
        System.out.println("Alunos da turma " + nometurma + ":");
        for (Aluno aluno : alunos) {
            System.out.println("CPF: "+ aluno.getCpf() + "Nome: "+ aluno.getAluno());
        }
    }
}

