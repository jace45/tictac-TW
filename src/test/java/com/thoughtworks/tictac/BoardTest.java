package com.thoughtworks.tictac;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

//import java.io.PrintStream;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;

public class BoardTest {

    private Board board;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = new Board(printStream);
    }

    @Test
    public void shouldDrawBoardWhenDrawIsCalled() {

        verify(printStream).println("1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");
     }

    @Test
    public void shouldReturnDrawBoardWithAXOnTwoWhenDrawXIsCalled() {

        board.drawsSymbolOnBoard("2", "X");
        verify(printStream).println("1|X|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");
     }

    @Test
    public void shouldReturnDrawBoardWithAXAndOOnTheBoard() {

        board.drawsSymbolOnBoard("2", "X");
        board.drawsSymbolOnBoard("5", "O");
        verify(printStream).println("1|X|3\n" +
                "-----\n" +
                "4|O|6\n" +
                "-----\n" +
                "7|8|9");
     }

    @Test
    public void shouldPrintLocationTakenWhenInputIsGivenForALocationAlreadyTaken(){

        board.drawsSymbolOnBoard("2", "X");
        board.isNotAValidMove("2");

        verify(printStream).println("Location already taken");
    }

    @Test
    public void shouldBeFalseWhenBoardIsFilled() {
        board.drawsSymbolOnBoard("1", "X");
        board.drawsSymbolOnBoard("2", "X");
        board.drawsSymbolOnBoard("3", "X");
        board.drawsSymbolOnBoard("4", "X");
        board.drawsSymbolOnBoard("5", "X");
        board.drawsSymbolOnBoard("6", "O");
        board.drawsSymbolOnBoard("7", "O");
        board.drawsSymbolOnBoard("8", "O");
        board.drawsSymbolOnBoard("9", "O");

        assertThat(board.boardIsNotFilled(), is(false));
    }

    @Test
    public void shouldBeTrueWhenBoardIsNotFilled() {
        board.drawsSymbolOnBoard("1","X");
        board.drawsSymbolOnBoard("2","X");
        board.drawsSymbolOnBoard("5","X");
        board.drawsSymbolOnBoard("7","O");
        board.drawsSymbolOnBoard("8","O");
        board.drawsSymbolOnBoard("9","O");

        assertThat(board.boardIsNotFilled(), is(true));
    }
}