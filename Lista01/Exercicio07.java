package com.mycompany.lista1;

public class Exercicio07 {
    public static void main(String[] args){
        if (args.length == 0 || args.length > 4){
            System.out.println("Quantidade de parametros inválida");
        }
        else {
            double soma = 0;
            for (var index = 0; index < args.length; index++){
                soma = soma + Math.pow(Double.parseDouble(args[index]), index + 1);
            }
            System.out.printf("Resutado da soma: %f", soma);
        }
    }
}
