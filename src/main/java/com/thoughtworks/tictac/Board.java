package com.thoughtworks.tictac;

import java.io.PrintStream;

import static java.lang.Integer.parseInt;

public class Board {


    protected String [] boardGame;
    private PrintStream printStream;

    public Board(PrintStream printStream){
        this.printStream = printStream;
        boardGame = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    }

    public void drawBoard() {
        String one = boardGame[0];
        String two = boardGame[1];
        String three = boardGame[2];
        String four = boardGame[3];
        String five = boardGame[4];
        String six = boardGame[5];
        String seven = boardGame[6];
        String eight = boardGame[7];
        String nine = boardGame[8];

        printStream.println(one + "|" + two + "|" + three +"\n" +
                "-----\n" +
                four + "|" + five + "|" + six + "\n" +
                "-----\n" +
                seven + "|" + eight + "|" + nine);
    }

    public void drawsSymbolOnBoard(String position, String symbol) {
        for (int i = 0; i < boardGame.length; i++) {
            if (position.equals(boardGame[i])) {
                boardGame[i] = symbol;
            }
        }
    }

    public boolean isNotAValidMove(String position) {
        int positionInArray = parseInt(position) - 1;

        if (position.equals(boardGame[positionInArray])){
            return false;
        } else {
            printStream.println("Location already taken");
            return true;
        }
    }

    public boolean boardIsNotFilled() {
        for (int i=0; i< boardGame.length; i++){
            if(!(boardGame[i].equals("X") || boardGame[i].equals("O"))){
                return true;
            }
        }
        return false;
    }
}
