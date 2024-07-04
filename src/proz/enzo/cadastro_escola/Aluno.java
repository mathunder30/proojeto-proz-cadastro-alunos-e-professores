package proz.enzo.cadastro_escola;
import java.util.ArrayList;
import java.util.Scanner;

public class Aluno {
    private String nome;
    private String cpf;
    private String senha;
    private String email;
    private String escolaridade;
    
    

    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getSenha() {
        return senha;
    }
    public String getEmail() {
        return email;
    }
    public String getEscolaridade() {
        return escolaridade;
    }
    public Aluno(String nome, String cpf, String senha){
        // this vai significar ESTE REGISTRO
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        


    }
    public Aluno(String email, String escolaridade,String nome, String cpf, String senha){
        this.escolaridade = escolaridade;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;

    }
   

    public void printInformacao(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Escolaridade: "+this.escolaridade);
        System.out.println("CPF: "+this.cpf);
        System.out.println("Email: "+ this.email);
        System.out.println("Senha: " + this.senha);
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setcpf(String cpf) {
        this.cpf = cpf;
    }
    
    public void setsenha(String senha) {
        this.senha = senha;
    }
    public void setemail(String email) {
        this.email = email;
    }
   
    
    public void setescolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        boolean repeticao = true;
        ArrayList<Aluno> ArrayAlunos = new ArrayList<>();
        
        

        boolean escolhasInteracao = true;
        while (escolhasInteracao) {
            System.out.println("digite as opções que voce deseja: ");
            System.out.println("1. cadastrar novo usuario: ");
            System.out.println("2. visualizar todos os usuarioss: ");
            System.out.println("3. Alterar usuario: ");
            System.out.println("4. Sair");
            int opcoes = sc.nextInt();
            if (opcoes == 1) {
                do {
            
            
            System.out.println("Digite o seu nome: ");
            String AlunoNome = sc.nextLine();
            System.out.println("Qual é a sua escolaridade?");
            String AlunoEscolaridade = sc.nextLine();
            System.out.println("Digite o seu cpf: ");
            String AlunoCPF = sc.nextLine();
            System.out.println("Digite o seu email: ");
            String AlunoEmail = sc.nextLine();
            System.out.println("Digite a sua senha: ");
            String AlunoSenha = sc.nextLine();
            ArrayAlunos.add(new Aluno(AlunoNome, AlunoEscolaridade, AlunoCPF, AlunoEmail, AlunoSenha));
            System.out.println("digite o 0 para sair e 1 para continuar");
            int verificacao = sc.nextInt();
            if (verificacao == 0) {
                repeticao = false;
                
            }
        }while (repeticao);
        
            } else if (opcoes == 2) {
                for (Aluno x : ArrayAlunos){
                    x.printInformacao();
                }
            } else if (opcoes == 3) {
                System.out.println("Digite o cpf do usuario que voce deseja alterar? ");
                String cpfDigite = sc.nextLine();

                for(Aluno x : ArrayAlunos){ 
                    if(x.cpf == cpfDigite  ){
                        System.out.println("Qual que você quer modificar?");
                        System.out.println("1.Nome \n 2.Escolaridade \n 3.CPF \n 4.Email \n 5.Senha \n 6. Sair");
                        int opcaoAlterar = sc.nextInt();
                        if (opcaoAlterar == 1) {
                            System.out.println("Digite o nome que deseja alterar: ");
                            String NovoNome = sc.nextLine();
                            x.setNome(NovoNome);

                            
                        }
                    }
                }

                
            }
            
        } 
        

        sc.close();
 
    
    
}
}


