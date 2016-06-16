package com.thoughtworks.tictac;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Game {
    private Board board;
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private User user;
    private User[] users;

    public Game(Board board, PrintStream printStream, BufferedReader bufferedReader, User[] users) {

        this.board = board;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.user = users[0];
        this.users = users;
    }

    public void start() {
        int x = 0;
        printStream.println(board.drawBoard());
        while (x != 2){
            playOnBoard();
            x++;
        }
    }

    public void playOnBoard() {
            printStream.println(user.getName() + " please choose a number between 1-9");
            String userInput = read();

            board.drawsSymbolOnBoard(userInput, user.getSymbol());
            printStream.println(board.drawBoard());
            changeUsers();

    }

    private void changeUsers() {
        if (user.equals(users[0])){
            user = users[1];
        } else{
            user = users[0];
        }
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
