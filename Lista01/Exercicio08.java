package com.mycompany.lista1;

import java.util.Arrays;
import java.util.Collections;

class Numero{
    int numero;

    public Numero(int numero){
        this.numero = numero;
        System.out.printf((validar() ? "O número %d é válido\n" : "O número %d é invalido\n"), numero);
    }

    public boolean validar(){
        var caracteres = Integer.toString(numero).toCharArray();
        Collections.reverse(Arrays.asList(caracteres));
        int soma = 0;
        for (int index = 0; index < caracteres.length; index++){
            var valorComoInteiro = Integer.parseInt(String.valueOf(caracteres[index]));
            soma = soma + (int) Math.pow(valorComoInteiro, caracteres.length);
        }
        return soma == numero;
    }
}

public class Exercicio08 {
    public static void main(String[] args){
        new Numero(153);
        new Numero(2);
        new Numero(11111);
        new Numero(9474);
    }
}
