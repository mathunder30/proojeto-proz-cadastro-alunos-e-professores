package proz.enzo.cadastro_escola;

import java.util.ArrayList;
import java.util.Scanner;


public class disciplina{
     public String portugues , matematica;

    
    public disciplina (String portugues, String matematica){
        this.portugues = portugues;
        this.matematica = matematica;
        
    }

   public void exibir(){
    System.out.println("Portugues: " + this.portugues);
    System.out.println("Matematica: " +   this.matematica);
    
   }


public String getPortugues() {
    return portugues;
}

public void setPortugues(String portugues) {
    this.portugues = portugues;
}

public String getMatematica() {
    return matematica;
}

public void setMatematica(String matematica) {
    this.matematica = matematica;
}

public void setportugues(String novamateria) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setportugues'");
}

public void setmatematica(String nova2materia) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setmatematica'");
}
   
   /**
 * @param args
 * @throws Exception
 */
public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    boolean escolheaInteracao = true;
    boolean repeticao = true;
    ArrayList<disciplina> escola = new ArrayList<>();
    
    System.out.println("digite as opções que voce deseja: ");
    System.out.println("1. cadastrar nova Matéria : ");
    System.out.println("2. visualizar todas as Matérias: ");
    System.out.println("3. Alterar Matéria : ");
    System.out.println("4. Sair");
    int opcoes = sc.nextInt();
    while (repeticao) {
      if (opcoes == 1) {
        do{
            System.out.println("Digite a sua Primeira Disciplina : ");
            String novamateria = sc.next();
            System.out.println("Digite a sua Segunda Disciplina : ");
            String nova2materia = sc.next();
           escola.add(new disciplina (novamateria, nova2materia ));
            System.out.println("digite 0 para encerrar \ndigite 1 para continuar");
            int verificacao = sc.nextInt();
            if(verificacao == 0){
                repeticao = false;
            
                break;
            }
                             
            
        }while(repeticao);
        
    } else if(opcoes == 2){
        for(disciplina x : escola){
            x.exibir();
        } 
    } else if(opcoes == 3){
        System.out.println("digite a Turma que você quer modificar a Disciplina: ");
        String materialterar = sc.next();

        boolean found = false;

        for(disciplina x : escola){
            if (x.matematica.equals(materialterar)) {
                
                found = true;

                System.out.println("Qual campo que você deseja modificar? ");
                System.out.println("1. Primeira Matéria  \n2. Segunda Matéria");
                int opcoesAlterar = sc.nextInt();
                if (opcoesAlterar == 1) {
                    System.out.println("Digite a matéria que deseja alterar: ");
                    String novamateria = sc.nextLine();
                    x.setportugues(novamateria);
                    
                } else if(opcoesAlterar == 2){
                    System.out.println("Digite a Segunda matéria que você quer alterar: ");
                    String nova2materia = sc.next();
                    x.setmatematica(nova2materia);
               
                    
                }
                
            }
        } if (!found) {
            System.out.println("aa turma "+materialterar+" não foi encontrado");
            
        }
    } else if (opcoes == 4) {

        System.out.println("saindo...");
        break;
                
    }  
    }

    

sc.close();
    
}

public static void add(disciplina disciplina) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'add'");
} 
}