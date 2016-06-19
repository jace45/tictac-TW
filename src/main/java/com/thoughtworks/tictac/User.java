package com.thoughtworks.tictac;

import java.io.BufferedReader;
import java.io.IOException;

public class User {

    private String name;
    private String symbol;
    private Board board;
    private BufferedReader bufferedReader;

    public User(String name, String symbol, BufferedReader bufferedReader, Board board) {

        this.name = name;
        this.symbol = symbol;
        this.bufferedReader = bufferedReader;
        this.board = board;
    }

    public void userPlaysTheirSymbol() {
        String userInput;
        do {
            userInput = read();
        } while (board.isNotAValidMove(userInput));
        board.drawsSymbolOnBoard(userInput, symbol);

    }

    public String getName() {

        return name;
    }

    private String read() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
