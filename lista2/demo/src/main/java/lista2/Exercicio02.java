package main.java.lista2;

import java.util.Scanner;

public class Exercicio02 {

    public static String joinStrings(String string1, String string2){
        var longestLength = string1.length() > string2.length() ? string1.length() : string2.length();
        String finalString = "";
        for (var index = 0; index < longestLength; index++){
            if (index < string1.length()){
                finalString = finalString.concat(String.valueOf(string1.charAt(index)));
            }
            if (index < string2.length()){
                finalString = finalString.concat(String.valueOf(string2.charAt(index)));
            }
        }
        return finalString;
    }
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Esse programa irá juntar duas palavras");
        System.out.println("Digite a primeira palavra");
        var string1 = scanner.nextLine();
        System.out.println("Digite a segunda palavra");
        var string2 = scanner.nextLine();
        System.out.println(joinStrings(string1, string2));
        scanner.close();
    }
}
