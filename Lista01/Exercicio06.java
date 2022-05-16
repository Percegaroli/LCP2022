/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista1;

enum TipoTriangulo{
    ISOSCELES,
    ESCALENO,
    EQUILATERO
}

interface Geometria {
    public double defineArea();

    public double definePerimetro();
}

class Quadrado implements Geometria{
    private double lado;

    public Quadrado(double lado){
        this.lado = lado;
    }

    public double defineArea(){
        return Math.pow(lado, 2);
    }

    public double definePerimetro(){
        return lado * 4; 
    }
}

class Retangulo implements Geometria {
    private double base;
    private double altura;

    public Retangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    public double defineArea(){
        return base * altura;
    }

    public double definePerimetro(){
        return 2 * (base + altura);
    }
}


class Triangulo implements Geometria {
    private double ladoA;
    private double ladoB;
    private double ladoC;

    public Triangulo(double ladoA, double ladoB, double ladoC){
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    /**
     * Calcula a area do triangulo pela Formula de Heron
     */
    public double defineArea(){
        var semiperimetro = getSemiperimetro();
        return Math.sqrt(semiperimetro * (semiperimetro - ladoA) * (semiperimetro - ladoB) * (semiperimetro - ladoC));
    }

    private double getSemiperimetro(){
        return definePerimetro() / 2;
    }

    public double definePerimetro(){
        return ladoA + ladoB + ladoC;
    }
}

class Circulo implements Geometria {
    private double raio;

    public Circulo(double raio){
        this.raio = raio;
    }

    public double defineArea(){
        return Math.PI * Math.pow(raio, 2);
    }

    public double definePerimetro(){
        return 2 * Math.PI * raio;
    }
}

class TestaGeometria {
    public TestaGeometria(){
        printQuadrado(4);
        printQuadrado(6);
        printTriangulo(2, 4, 7);
        printTriangulo(15, 15, 1);
        printCirculo(4);
        printCirculo(12);
        printRetangulo(4, 8);
        printRetangulo(10, 11);
    }

    private void printRetangulo(double base, double altura){
        var forma = new Retangulo(base, altura);
        System.out.printf("Retângulo de base %.4f e altura %.4f\n", base, altura);
        printDimensoesGeometria(forma);
    }

    private void printCirculo(double raio){
        var forma = new Circulo(raio);
        System.out.printf("Círculo de raio %.4f\n", raio);
        printDimensoesGeometria(forma);
    }

    private void printTriangulo(double ladoA, double ladoB, double ladoC){
        var triangulo = new Triangulo(ladoA, ladoB, ladoC);
        System.out.printf("Triângulo de lados %.4f, %.4f, %.4f\n", ladoA, ladoB, ladoC);
        printDimensoesGeometria(triangulo);
    }

    private void printQuadrado(double lado){
        var quadrado = new Quadrado(lado);
        System.out.printf("Quadrado de lado %.4f\n", lado);
        printDimensoesGeometria(quadrado);
    }

    private void printDimensoesGeometria (Geometria forma){
        printArea(forma);
        printPerimetro(forma);
        System.out.println();
    }

    private void printArea(Geometria forma){
        System.out.printf("Área: %.4f\n", forma.defineArea());
    }

    private void printPerimetro(Geometria forma){
        System.out.printf("Perímetro: %.4f\n", forma.definePerimetro());
    }
}

public class Exercicio06 {
    public static void main(String[] args){
        new TestaGeometria();
    }
}
