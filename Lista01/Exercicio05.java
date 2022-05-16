package com.mycompany.lista1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Livro {
    String titulo;

    public String getTitulo(){
        return titulo;
    }

    public abstract void setTitulo(String titulo);
}

class LivroGratuito extends Livro {
    @Override
    public void setTitulo(String titulo) {
        super.titulo = titulo;
    }

    @Override
    public String toString(){
        return String.format("Título: %s, Preço: Gratuíto!\n", super.getTitulo());
    }
}

class LivroPago extends Livro {
    private float preco;

    public float getPreco(){
        return preco;
    }

    public void setPreco(float preco){
        this.preco = preco;
    }

    @Override
    public void setTitulo(String titulo) {
        super.titulo = titulo;
    }

    public String toString(){
        return String.format("Título: %s, preço: %.2f\n", super.getTitulo(), getPreco());
    }
}

class Biblioteca{
    List<Livro> livros;

    public Biblioteca(){
        livros = new ArrayList<Livro>();
        var lusiadas = new LivroGratuito();
        lusiadas.setTitulo("Os lusíadas");
        var harryPotter = new LivroPago();
        harryPotter.setTitulo("Harry Potter");
        harryPotter.setPreco(30.99f);
        var lotr = new LivroPago();
        lotr.setTitulo("O senhor dos anéis");
        lotr.setPreco(40.0f);
        livros.addAll(Arrays.asList(lusiadas, harryPotter, lotr));
    }

    @Override
    public String toString(){
        String finalString = "";
        livros.stream().forEach(livro -> finalString.concat(livro.toString()));
        return finalString;
    }
}

public class Exercicio05 {
    public static void main(String[] args){
        var biblioteca = new Biblioteca();
        System.out.println(biblioteca);
    }
}
