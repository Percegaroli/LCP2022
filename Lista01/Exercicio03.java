/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista1;

class Funcionario{
    private String nome;
    private int idade;
    private float salario;

    public Funcionario(String nome, int idade, float salario) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }
    
    @Override
    public String toString(){
        return String.format("O funcionário %s, de idade %d. recebe um salário de %.2f e paga %.2f de impostos\nA empresa para qual %s trabalha terá que pagar %.2f de impostos\n", nome, idade, salario, Contribuicao.getContribuicaoFuncionario(idade, salario), nome, Contribuicao.getContribuicaoEmpresa(idade, salario) );
    }
}   

class Contribuicao{
    public static float getContribuicaoEmpresa(int idade, float salario){
        return getSalarioTributacao(salario)* getPorcentagemEmpresa(idade);
    }
    
    public static float getContribuicaoFuncionario(int idade, float salario){
        return getSalarioTributacao(salario) * getPorcentagemFuncionario(idade);
    }
    
    private static float getSalarioTributacao(float salarioBase){
        return  salarioBase > 5000f ? 5000f : salarioBase;
    }
    
    private static float getPorcentagemFuncionario(int idade){
        if (idade < 30){
            return 0.2f;
        }
        if (idade < 40){
            return 0.18f;
        }
        if (idade < 50){
            return 0.12f;
        }
        if (idade < 60){
            return 0.07f;
        }
        return 0.03f;
    }
    
    private static float getPorcentagemEmpresa (int idade){
        if (idade < 30){
            return 0.18f;
        }
        if (idade < 40){
            return 0.15f;
        }
        if (idade < 50){
            return 0.15f;
        }
        if (idade <60){
            return 0.1f;
        }
        return 0.04f;
    }
}

/**
 *
 * @author aluno
 */
public class Exercicio03 {
    public static void main(String[] args){
        System.out.println(new Funcionario("Henrique Pereira", 24, 1000f));
        System.out.println(new Funcionario("Ronaldo Weslei", 33, 3300f));
        System.out.println(new Funcionario("Douglas Malfeito", 42, 5000f));
        System.out.println(new Funcionario("Sérgio Isneipe", 55, 3300f));
        System.out.println(new Funcionario("Vanderlei", 66, 2400f));
    }
}
