package com.thoughtworks.tictac;

public class Board {


    protected String [][] boardGame;

    public Board(){
        boardGame = new String[][]{{"1", "2", "3"},
                                    {"4", "5", "6"},
                                    {"7", "8", "9"}};

    }

    public String drawBoard() {
        String one = boardGame[0][0];
        String two = boardGame[0][1];
        String three = boardGame[0][2];
        String four = boardGame[1][0];
        String five = boardGame[1][1];
        String six = boardGame[1][2];
        String seven = boardGame[2][0];
        String eight = boardGame[2][1];
        String nine = boardGame[2][2];

        return one + "|" + two + "|" + three +"\n" +
                "-----\n" +
                four + "|" + five + "|" + six + "\n" +
                "-----\n" +
                seven + "|" + eight + "|" + nine;
    }

    public void drawsSymbolOnBoard(String position, String symbol) {
        for(int i=0; i<boardGame.length; i++){
            for(int j=0; j<boardGame[0].length; j++){
                if (position.equals(boardGame[i][j])){
                    boardGame[i][j] = symbol;
                }
            }
        }
    }

}
