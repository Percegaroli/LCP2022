package main.java.lista2;

import java.util.Scanner;

class Tabuleiro {
    private char[][]tabuleiro = {{
        '_', '_', '_'
    }, {
        '_', '_', '_'
    }, {
        '_', '_', '_'
    }};
    private char nextPlayer = 'X';

    public void reset(){
        for (var i = 0; i < 3; i++){
            for(var j = 0; j < 3; j++){
                tabuleiro[i][j] = '_';
            }
        }
        nextPlayer = 'X';
    }

    public char getNextPlayer() {
        return nextPlayer;
    }

    public boolean markCell(int line, int column){
        if (line >= 3 || column >=3){
            System.out.println("Casa inválida!");
            return false;
        }
        if (getIsCellALreadyMarked(line, column)){
            System.out.println("A casa escolhida ja foi marcada");
            return false;
        }
        tabuleiro[line][column] = nextPlayer;
        nextPlayer = nextPlayer == 'X' ? 'O' : 'X';
        return true;
    }


    public Character getWinner(){
        var winnerFromLine = getWinnerFromLine();
        if (winnerFromLine != null){
            return winnerFromLine;
        }
        var winnerFromColumn = getWinnerFromColumn();
        if (winnerFromColumn != null){
            return winnerFromColumn;
        }
        var winnerFromDiagonal = getWinnerFromDiagonal();
        if (winnerFromDiagonal != null){
            return winnerFromDiagonal;
        }
        return null;
    }

    public boolean getDoesGameHaveWinner(){
        return getWinner() != null;
    }

    public boolean getIsGameOver(){
        return areAllCellsMarked() || getDoesGameHaveWinner();
    }

    private boolean areAllCellsMarked(){
        for (var i = 0; i < 3; i++){
            for (var j =0; j < 3; j++){
                if (tabuleiro[i][j] == '_'){
                    return false;
                }
            }
        }
        return true;
    }

    public void printTabuleiro(){
        for (var i = 0; i < 3; i++){
            for (var j = 0; j <3; j++){
                System.out.printf("%c ", tabuleiro[i][j]);
            }
            System.out.println();
        }
    }

    private boolean getIsCellALreadyMarked(int line, int column){
        return tabuleiro[line][column] != '_';
    }

    private Character getWinnerFromLine(){
        for (var i = 0; i < 3; i++){
            if (getIsCellALreadyMarked(i, 0) && tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][0] == tabuleiro[i][2]){
                return tabuleiro[i][0];
            }
        }
        return null;
    }

    private Character getWinnerFromColumn(){
        for (var i = 0; i< 3; i++){
            if (getIsCellALreadyMarked(0, i) && tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[0][i] == tabuleiro[2][i]){
                return tabuleiro[0][i];
            }
        }
        return null;
    }

    private Character getWinnerFromDiagonal(){
        if (!getIsCellALreadyMarked(1, 1)){
            return null;
        }
        if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]){
            return tabuleiro[0][0];
        }
        if (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]){
            return tabuleiro[1][1];
        }
        return null;
    }
}

public class JogoVelha {
    public static int getPlayerFromChar(char character){
        return character == 'X' ? 1 : 2;
    }
    public static void main(String[] args) {
        var tabuleiro = new Tabuleiro();
        var scanner = new Scanner(System.in);
        while(!tabuleiro.getIsGameOver()){
            tabuleiro.printTabuleiro();
            System.out.printf("\nVez do jogador %d\n", getPlayerFromChar(tabuleiro.getNextPlayer()));
            System.out.println("Digite a casa que você deseja marcar, no formato 00: \nprimeiro numero = linha, segundo numero = coluna, começando a partir de 0");
            var jogada = scanner.nextLine();
            if (jogada.replace("\\D", "").length() != 2){
                System.out.println("Casa inválida");
            }
            else {
                int line = Integer.parseInt(String.valueOf(jogada.charAt(0)));
                int column = Integer.parseInt(String.valueOf(jogada.charAt(1)));
                tabuleiro.markCell(line, column);
            }
            System.out.println("\n----------------\n");
        }

        tabuleiro.printTabuleiro();
        if (tabuleiro.getDoesGameHaveWinner()){
            System.out.printf("\nO jogador %d venceu\n", getPlayerFromChar(tabuleiro.getWinner()));
        }
        else {
            System.out.println("Deu velha!");
        }

        scanner.close();
    }
}
