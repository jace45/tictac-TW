package com.thoughtworks.tictac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

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

    public String userPlaysTheirSymbol(){
        String userInput = read();
        board.drawsSymbolOnBoard(userInput, symbol);

        return userInput;
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
