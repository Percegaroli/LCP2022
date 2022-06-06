package lista2;

import java.util.Scanner;

public class Telefones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número de telefone, incluindo o DDD");
        String telefone = scanner.nextLine();
        String phoneNumbersOnly = telefone.replaceAll("\\D", "");
        boolean isCellphone = phoneNumbersOnly.length() == 11;
        boolean isResidential = phoneNumbersOnly.length() == 10;
        if (!isCellphone && !isResidential){
            System.out.println("Número de telefone inválido");
        }
        else {
            System.out.printf("Esse é um número de telefone %s\n", isResidential ? "residencial" : "celular");
            System.out.printf("O DDD é %s e o telefone é %s\n", phoneNumbersOnly.substring(0, 2), phoneNumbersOnly.substring(2));
        }
        scanner.close();
    }
}
