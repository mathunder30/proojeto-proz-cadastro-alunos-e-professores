package proz.enzo.cadastro_escola;
import java.util.ArrayList;
import java.util.Scanner;

public class Professor {
    private String nome;
    private String cpf;
    private String matricula;
    private String masp;
    private String idade;
    private String cep;
    private String genero;

    public Professor(String nome, String cpf, String matricula, String masp, String idade, String cep, String genero){
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.masp = masp;
        this.idade = idade;
        this.cep = cep;
        this.genero = genero;

    


    }
    public void printInformacaoProfessor(){
        System.out.println("Nome: "+ this.nome);
        System.out.println("CPF: "+this.cpf);
        System.out.println("Matricula: "+this.matricula);
        System.out.println("MASP: "+this.masp);
        System.out.println("idade: "+ this.idade);
        System.out.println("CEP: "+this.cep);
        System.out.println("Sexo: "+ this.genero);

    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setcpf(String cpf){
        this.cpf = cpf;

    } 
    public void setMatricula (String matricula){
        this.matricula = matricula; 

    }
    public void setMasp (String masp){
        this.masp = masp;
    }
    public void setIdade (String idade){
        this.idade = idade;
    }
    public void setCep (String cep){
        this.cep = cep;
    }
    public void setSexo (String genero){
        this.genero = genero;
    }
    
    
    
    
    
    
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean escolheaInteracao = true;
        boolean repeticao = true;
        ArrayList<Professor> teacher = new ArrayList<>();
       
        while (escolheaInteracao) {
            System.out.println("digite as opções que voce deseja: ");
            System.out.println("1. cadastrar novo usuario: ");
            System.out.println("2. visualizar todos os usuarioss: ");
            System.out.println("3. Alterar usuario: ");
            System.out.println("4. Sair");
            int opcoes = sc.nextInt();

            if (opcoes == 1) {
                do{
                    System.out.println("Digite o seu nome: ");
                    String ProfNome = sc.next();
                    System.out.println("Digite o seu CPF: ");
                    String ProfCPF = sc.next();
                    System.out.println("Digite a sua matricula: ");
                    String ProfMatricula = sc.next();
                    System.out.println("Digite o seu MASP: ");
                    String ProfMASP = sc.next();
                    System.out.println("Digite sua idade: ");
                    String ProfIdade = sc.next();
                    System.out.println("Digite o seu CEP: ");
                    String ProfCep = sc.next();
                    System.out.println("Digite o seu genero: ");
                    String ProfGenero = sc.next();
                    teacher.add(new Professor(ProfNome, ProfCPF, ProfMatricula, ProfMASP, ProfIdade, ProfCep, ProfGenero));
                    System.out.println("digite 0 para encerrar \ndigite 1 para continuar");
                    int verificacao = sc.nextInt();
                    if(verificacao == 0){
                        break;
                    }
                                     
                    
                }while(repeticao);
                
            } else if(opcoes == 2){
                for(Professor x : teacher){
                    x.printInformacaoProfessor();
                } 
            } else if(opcoes == 3){
                System.out.println("digite o cpf do usuario que você quer modificar");
                String CPFalterar = sc.next();

                boolean found = false;

                for(Professor x : teacher){
                    if (x.cpf.equals(CPFalterar)) {
                        
                        found = true;

                        System.out.println("Qual campo que você deseja modificar? ");
                        System.out.println("1. Nome \n2. CPF \n3. Matricula \n4. MASP \n5. Idade \n6. CEP \n7. Sexo");
                        int opcoesAlterar = sc.nextInt();
                        if (opcoesAlterar == 1) {
                            System.out.println("Digite o nome que deseja alterar: ");
                            String NovoNome = sc.next();
                            x.setNome(NovoNome);
                            
                        } else if(opcoesAlterar == 2){
                            System.out.println("Digite o CPF que você quer alterar: ");
                            String novoCPF = sc.next();
                            x.setcpf(novoCPF);
                        } else if (opcoesAlterar == 3) {
                            System.out.println("Digite a nova matricula: ");
                            String novaMatricula = sc.next();
                            x.setMatricula(novaMatricula);

                        } else if (opcoesAlterar == 4) {
                            System.out.println("Digite o novo MASP: ");
                            String novoMASP = sc.next();
                            x.setMasp(novoMASP);
                            
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
                break;
                
            }


            
        }
        sc.close();
    }
}
