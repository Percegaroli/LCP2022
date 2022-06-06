package lista2;

import java.util.Scanner;

public class Verifica {

    public static boolean getIsRGValido(String rg){
        String[] rgParts = rg.split("\\.");
        if (rgParts.length != 3){
            return false;
        }
        String[] rgFinalPart = rgParts[2].split("-");
        if (rgFinalPart.length != 2){
            return false;
        }
        if (rgParts[0].length() != 1 && rgParts[0].length() != 2){
            return false;
        }
        if (rgParts[1].length() != 3 && rgFinalPart[0].length() != 3){
            return false;
        }
        return rgFinalPart[1].length() == 1 && (rgFinalPart[1].equals("X") ||rgFinalPart[1].matches("\\d"));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um RG, no formato 00.000.000.0");
        String rg = scanner.nextLine();
        System.out.println(getIsRGValido(rg) ? "O RG informado é válido" : "O RG informado não é válido");
        scanner.close();
    }
}
