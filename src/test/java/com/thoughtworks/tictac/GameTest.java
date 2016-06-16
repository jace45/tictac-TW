package com.thoughtworks.tictac;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class GameTest {

    private PrintStream printStream;
    private Board board;
    private Game game;
    private BufferedReader bufferedReader;
    private User user0;
    private User user1;
    private User[] users;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        bufferedReader = mock(BufferedReader.class);
        user0 = mock(User.class);
        user1 = mock(User.class);
        users = new User[]{user0, user1};
        game = new Game(board, printStream, bufferedReader, users);
    }

    @Test
    public void shouldDrawBoardWhenGameStarts() {
        game.start();

        verify(board).drawBoard();

     }

    @Test
    public void shouldPromptUser1ToEnterAnInput() {

        game.start();

        verify(user0).getName();
        verify(printStream).println(contains("please choose a number between 1-9"));
     }

    @Test
    public void shouldCallDrawAgainWhenFirstUserInputsANumber() throws IOException {
        //BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("2");

        game.start();

        verify(board, times(2)).drawBoard();
        verify(board).drawsSymbolOnBoard("2", "X");
     }

    @Test
    public void shouldPromptUserTwoToChooseANumber() {
        game.start();

        //verify(printStream).println(users.getName() + " please choose a number between 1-9");


     }
}