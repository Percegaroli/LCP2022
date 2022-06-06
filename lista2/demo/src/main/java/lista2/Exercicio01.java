package main.java.lista2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Esse programa normalizará um nome");
        System.out.println("Digite um nome completo");
        var fullName = scanner.nextLine();
        scanner.close();
        var splitedName = fullName.split(" ");
        List<String> preposicoes = new ArrayList<>();
        preposicoes.add("da");
        preposicoes.add("de");
        preposicoes.add("do");
        List<String> normalizedWords = new ArrayList<>();
        for (String word: splitedName){
            var wordAsLowerCase = word.toLowerCase();
            if (!preposicoes.contains(wordAsLowerCase)){
                normalizedWords.add(wordAsLowerCase.substring(0, 1).toUpperCase().concat(wordAsLowerCase.substring(1)));
            } else {
                normalizedWords.add(wordAsLowerCase);
            }
        }
        String finalName = normalizedWords.stream()
            .reduce("", (accumulator, element) -> 
                accumulator.concat(String.format(" %s", element)));
        System.out.printf("Nome normalizado:\n%s", finalName);
    }
}
