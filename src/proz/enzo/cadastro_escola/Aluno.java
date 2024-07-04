package proz.enzo.cadastro_escola;
import java.util.ArrayList;
import java.util.Scanner;


public class Aluno{
     public String aluno , cep;
     public String matricula, idade , sexo , cpf ;

    
    public Aluno (String aluno, String cpf ,String idade, String  matricula, String cep , String sexo){
        this.aluno = aluno;
        this.cpf = cpf;
        this.idade = idade;
        this.matricula = matricula;
        this.cep = cep;
        this.sexo = sexo;

    }

   public void exibir(){
    System.out.println("Aluno: " + this.aluno);
    System.out.println("CPF: " +   this.cpf);
    System.out.println("Idade: " + this.idade);
    System.out.println("Matrícula: " + this.matricula);
    System.out.println("Cep: " + this.cep);
    System.out.println("Sexo: " + this.sexo);
   }


public String getAluno() {
    return aluno;
}

public void setAluno(String aluno) {
    this.aluno = aluno;
}

public String getCep() {
    return cep;
}

public void setCep(String cep) {
    this.cep = cep;
}

public String getMatricula() {
    return matricula;
}

public void setMatricula(String matricula) {
    this.matricula = matricula;
}

public String getIdade() {
    return idade;
}

public void setIdade(String idade) {
    this.idade = idade;
}

public String getSexo() {
    return sexo;
}

public void setSexo(String sexo) {
    this.sexo = sexo;
}

public String getCpf() {
    return cpf;
}

public void setCpf(String cpf) {
    this.cpf = cpf;
}

public void setNome(String novoNome) {
    
    throw new UnsupportedOperationException("Unimplemented method 'setNome'");
}

public void setcpf(String novoCPF) {
    
    throw new UnsupportedOperationException("Unimplemented method 'setcpf'");
}
   
   /**
 * @param args
 * @throws Exception
 */
public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    
    boolean repeticao = true;
    ArrayList<Aluno> alunos = new ArrayList<>();
    
    
    while (repeticao) {
        System.out.println("digite as opções que voce deseja: ");
    System.out.println("1. cadastrar novo usuario: ");
    System.out.println("2. visualizar todos os usuarioss: ");
    System.out.println("3. Alterar usuario: ");
    System.out.println("4. Sair");
    int opcoes = sc.nextInt();
      if (opcoes == 1) {
 
            System.out.println("Digite o seu nome: ");
            String nomeAluno = sc.next();
            System.out.println("Digite o seu CPF: ");
            String cpfAluno = sc.next();
            System.out.println("Digite a sua matricula: ");
            String matriculaAluno = sc.next();
            System.out.println("Digite sua idade: ");
            String idadeAluno = sc.next();
            System.out.println("Digite o seu CEP: ");
            String cepAluno = sc.next();
            System.out.println("Digite o seu genero: ");
            String generoAluno = sc.next();
           alunos.add(new Aluno (nomeAluno, cpfAluno, matriculaAluno,idadeAluno, cepAluno,generoAluno ));
            
        
    } else if(opcoes == 2){
        for(Aluno x : alunos){
            x.exibir();
        } 
    } else if(opcoes == 3){
        System.out.println("digite o cpf do usuario que você quer modificar");
        String CPFalterar = sc.next();

        boolean found = false;

        for(Aluno x : alunos){
            if (x.cpf.equals(CPFalterar)) {
                
                found = true;

                System.out.println("Qual campo que você deseja modificar? ");
                System.out.println("1. Nome \n2. CPF \n3. Matricula \n 5. Idade \n6. CEP \n7. Sexo");
                int opcoesAlterar = sc.nextInt();
                if (opcoesAlterar == 1) {
                    System.out.println("Digite o nome que deseja alterar: ");
                    String NovoNome = sc.nextLine();
                    x.setNome(NovoNome);
                    
                } else if(opcoesAlterar == 2){
                    System.out.println("Digite o CPF que você quer alterar: ");
                    String novoCPF = sc.next();
                    x.setcpf(novoCPF);
                } else if (opcoesAlterar == 3) {
                    System.out.println("Digite a nova matricula: ");
                    String novaMatricula = sc.next();
                    x.setMatricula(novaMatricula);
                } else if (opcoesAlterar == 5) {
                    System.out.println("Digite a nova idade: ");
                    String novoIdade = sc.next();
                    x.setIdade(novoIdade);
                    
                } else if (opcoesAlterar == 6) {
                    System.out.println("Digite o novo CEP: ");
                    String novoCEP = sc.next();
                    x.setCep(novoCEP); 
                    
                } else if (opcoesAlterar == 7) {
                    System.out.println("Digite o genero: ");
                    String novoGenero = sc.next();
                    x.setSexo(novoGenero);

                    
                }
                
            }
        } if (!found) {
            System.out.println("oo usuario do CPF "+CPFalterar+" não foi encontrado");
            
        }
    } else if (opcoes == 4) {

        System.out.println("saindo...");
        int verificacao = sc.nextInt();
        if(verificacao == 0){
            repeticao=false;
        }
           
                
    }  
    
    }

    

sc.close();
    
} 
}