package com.thoughtworks.tictac;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        PrintStream printStream = System.out;
        Board board = new Board(printStream);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        User user1 = new User("User1", "X", bufferedReader, board);
        User user = new User("User2", "O", bufferedReader, board);
        User[] users = {user1, user};
        Game game = new Game(board, printStream, users);

        game.start();
    }
}
