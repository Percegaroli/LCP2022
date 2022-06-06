package main.java.lista2;

import java.util.Scanner;

public class Exercicio03 {

    public static boolean isPalindromo(String word){
        var reversedWord = new StringBuilder(word).reverse().toString().toLowerCase();
        System.out.println(reversedWord);
        var lowerCasedWord = word.toLowerCase();
        for (var index = 0; index < lowerCasedWord.length(); index++){
            if (lowerCasedWord.charAt(index) != reversedWord.charAt(index)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Esse programa irá verificar se palavra é palindromo");
        System.out.println("Digite uma palavra");
        System.out.println(isPalindromo(scanner.nextLine()) ? "A palavra fornecida é um palíndromo" : "A palavra fornecida não é um palíndromo");
        scanner.close();
    }
}
