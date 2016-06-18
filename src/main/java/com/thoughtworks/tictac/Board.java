package com.thoughtworks.tictac;

public class Board {


    protected String [] boardGame;

    public Board(){
        boardGame = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    }

    public String drawBoard() {
        String one = boardGame[0];
        String two = boardGame[1];
        String three = boardGame[2];
        String four = boardGame[3];
        String five = boardGame[4];
        String six = boardGame[5];
        String seven = boardGame[6];
        String eight = boardGame[7];
        String nine = boardGame[8];

        return one + "|" + two + "|" + three +"\n" +
                "-----\n" +
                four + "|" + five + "|" + six + "\n" +
                "-----\n" +
                seven + "|" + eight + "|" + nine;
    }

    public void drawsSymbolOnBoard(String position, String symbol) {
        for (int i = 0; i < boardGame.length; i++) {
            if (position.equals(boardGame[i])) {
                boardGame[i] = symbol;
            }
        }
    }

}
