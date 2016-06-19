package com.thoughtworks.tictac;


import java.io.PrintStream;

public class Game {
    private Board board;
    private PrintStream printStream;
    private User user;
    private User[] users;

    public Game(Board board, PrintStream printStream, User[] users) {

        this.board = board;
        this.printStream = printStream;
        this.user = users[0];
        this.users = users;
    }

    public void start() {
        do {
            board.drawBoard();
            printStream.println(user.getName() + " please choose a number between 1-9");
            user.userPlaysTheirSymbol();
            changeUsers();
        } while (board.boardIsNotFilled());
        board.drawBoard();
        printStream.println("Game is a draw");
    }


    private void changeUsers() {
        if (user.equals(users[0])){
            user = users[1];
        } else{
            user = users[0];
        }
    }
}
