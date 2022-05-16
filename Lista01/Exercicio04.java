/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista1;

import java.util.ArrayList;
import java.util.List;


class Animal{
    int idade;
    String name;

    public Animal(int idade, String name) {
        this.idade = idade;
        this.name = name;
    }
   
   public void realizaAcao(){
       
   }
   
    public void emitirSom(){
    }
}

class Cachorro extends Animal{

    public Cachorro(int idade, String name) {
        super(idade, name);
    }
    
    @Override
    public void emitirSom(){
        System.out.println("Au au");
    }
    
    private void correr(){
        System.out.printf("%s correu\n", super.name);
    }
    @Override
    public void realizaAcao(){
        correr();
    }
}

class Gato extends Animal{

    public Gato(int idade, String name) {
        super(idade, name);
    }
    
    @Override
    public void emitirSom(){
        System.out.println("Miau");
    }
    
    public void correr(){
        System.out.printf("%s correu\n", super.name);
    }
    
    public void pular(){
        System.out.printf("%s pulou\n", super.name);
    }
    
    @Override
    public void realizaAcao(){
        correr();
        pular();
    }
}

class Passaro extends Animal{

    public Passaro(int idade, String name) {
        super(idade, name);
    }
    
    @Override
    public void emitirSom(){
        System.out.println("Piu");
    }
    
    public void voar(){
        System.out.printf("%s saiu voando", super.name);
    }
    
    @Override
    public void realizaAcao(){
        voar();
    }
}

class ChamaAnimal{
    public ChamaAnimal(){
        List<Animal> animais = new ArrayList<>();
        animais.add(new Cachorro(5, "Totó"));
        animais.add(new Gato(15, "Mandrake"));
        animais.add(new Passaro(1, "Luke"));
        
        animais.stream().forEach(animal -> {
            System.out.printf("Chamando o animal %s\n", animal.name);
            animal.emitirSom();
            animal.realizaAcao();
            System.out.println("");
        });
    }
}
/**
 *
 * @author aluno
 */
public class Exercicio04 {
    
    public static void main(String[] args){
        new ChamaAnimal();
    }
}
