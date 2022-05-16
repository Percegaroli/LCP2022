/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista1;

import java.util.Scanner;

/**
 *
 * @author aluno
 */

class Operator{
    private float first;
    private float second;
    private float third;

    public Operator(float first, float second, float third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
    
    public void printSoma(){
        System.out.printf("A soma é: %f\n", first + second + third);
    }
    
    public void printProduto(){
        System.out.printf("O produto é: %f\n", first * second * third);
    }
    
    public void printOrdenados(){
        if (first < second){
            if (first < third){
                if (second < third){
                    System.out.printf("%f %f %f", first , second, third);
                } else{
                    System.out.printf("%f %f %f", first, third, second);
                }
            }
        }
        else if (first < third){
            if (second < third){
                System.out.printf("%f %f %f", first, second, third);
            }
            else {
                System.out.printf("%f %f %f",first , third, second);
            }
        }
        else if (second < third){
            System.out.printf("%f %f %f", second, third, first);
        }
        else {
            System.out.printf("%f %f %f", second, first, third);
        }
    }
}

public class Exercicio02 {
    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        System.out.println("Digite o primeiro número:");
        var first = scanner.nextFloat();
        System.out.println("Digite o segundo número:");
        var second = scanner.nextFloat();
        System.out.println("Digite o terceiro número");
        var third = scanner.nextFloat();
        scanner.close();
        var operator = new Operator(first, second, third);
        operator.printSoma();
        operator.printProduto();
        operator.printOrdenados();
    }
}
