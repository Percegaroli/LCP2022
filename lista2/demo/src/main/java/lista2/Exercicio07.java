package lista2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

class Aluno {
    private String name;
    private String RA;
    private int idade;
    private String curso;

    public Aluno(String name, String RA, int idade, String curso){
        this.name = name;
        this.RA = RA;
        this.idade = idade;
        this.curso = curso;
    }

    public String getRA() {
        return RA;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s, RA: %s, idade: %d, curso: %s", name, RA, idade, curso);
    }
}

public class Exercicio07 {
    public static void printInstructions(){
        System.out.println("Escolha uma operação");
        System.out.println("1 - Adicionar um novo aluno");
        System.out.println("2 - Remover um aluno");
        System.out.println("3 - Listar alunos");
        System.out.println("4 - Sair");
    }

    public static Optional<Aluno> getAlunoByRA(List<Aluno> alunos, String RA){
        return alunos.stream().filter(al -> 
            al
                .getRA()
                .equals(RA))
            .findFirst();
    }

    public static void createNewAluno(List<Aluno> alunos, Scanner scanner){
        System.out.println("Digite o nome do aluno:");
        String name = scanner.nextLine();
        System.out.println("Digite o RA do aluno");
        String ra = scanner.nextLine();
        System.out.println("Digite a idade do aluno");
        int idade = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite o nome do curso do aluno");
        String curso = scanner.nextLine();
        Optional<Aluno> aluno = getAlunoByRA(alunos, ra);
        if (aluno.isPresent()){
            System.out.println("Já existe um aluno com esse RA");
        } else {
            alunos.add(new Aluno(name, ra, idade, curso));
            System.out.println("Aluno adicionado com sucesso!");
        }
    }

    public static void removeAlunoFromList(List<Aluno> alunos, Scanner scanner){
        System.out.println("Digite o RA do aluno a ser removido");
        String ra = scanner.nextLine();
        
        Optional<Aluno> aluno= alunos.stream().filter(al -> al.getRA().equals(ra)).findFirst();
        if (aluno.isEmpty()){
            System.out.println("Não foi encontrado um aluno com esse RA");
        } else {
            alunos.remove(aluno.get());
            System.out.println("Aluno removido com sucesso!");
        }
    }

    public static void listAlunos(List<Aluno> alunos){
        alunos.forEach(aluno -> {
            System.out.println(aluno);
        });
    }

    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList<>();
        boolean shouldContinue = true;
        Scanner scanner = new Scanner(System.in);
        while (shouldContinue){
            printInstructions();
            int operation = Integer.parseInt(scanner.nextLine());
            System.out.println(operation);
            if (operation == 1){
                createNewAluno(alunos, scanner);
            } 
            else if (operation == 2){
                removeAlunoFromList(alunos, scanner);
            }
            else if (operation == 3){
                listAlunos(alunos);
            }
            else if (operation == 4){
                shouldContinue = false;
            }
            else {
                System.out.println("Operação inválida");
            }
            System.out.println("\n------------\n");
        }
        scanner.close();
    }
}
