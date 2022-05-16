/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Exercicio01 {
    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        System.out.println("Digite um número entre 1 e 20");
        int userNumber = scanner.nextInt();
        scanner.close();
        if (userNumber > 0){
            for (var index = 1; index <= userNumber; index++){
                List<String> asterisksList = new ArrayList<>(Collections.nCopies(index, "*"));
                var result = asterisksList.stream().reduce("", (accumulator, current) -> 
                    accumulator.concat(current)
                );
                System.out.printf("%s\n", result);
            }
        }
        else {
            System.out.println("Número invalido");
        }

     
    }

}
