package com.thoughtworks.tictac;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class GameTest {

    private PrintStream printStream;
    private Board board;
    private Game game;
    private User user0;
    private User user1;
    private User[] users;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        user0 = mock(User.class);
        user1 = mock(User.class);
        users = new User[]{user0, user1};
        game = new Game(board, printStream, users);
    }

    @Test
    public void shouldDrawBoardWhenGameStarts() {
        game.start();

        verify(board, times(2)).drawBoard();

     }

    @Test
    public void shouldPromptUser1ToEnterAnInput() {
        when(user0.getName()).thenReturn("foo");
        game.start();

        verify(printStream).println(contains("please choose a number between 1-9"));
     }

    @Test
    public void shouldCallDrawBoardTwiceWhenFirstUserInputsANumber() throws IOException {
        when(user0.getName()).thenReturn("foo");
        when(user1.getName()).thenReturn("fo");


        game.start();

        verify(board, times(2)).drawBoard();
     }

    @Test
    public void shouldPromptUserTwoToChooseANumber() throws IOException {
        when(user0.getName()).thenReturn("foo");
        when(board.boardIsNotFilled()).thenReturn(true,false);
        when(user1.getName()).thenReturn("fo");

        game.start();

        verify(printStream, times(2)).println(contains("please choose a number between 1-9"));

     }

    @Test
    public void shouldCheckToSeeIfGameIsADrawWhenBoardIsFilled() {
        when(user0.getName()).thenReturn("foo");

        game.start();

        verify(board).boardIsNotFilled();
    }

    @Test
    public void shouldSayItIsADrawWhenBoardIsFilled() {

        game.start();

        verify(printStream).println("Game is a draw");

     }

}