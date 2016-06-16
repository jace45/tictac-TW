package com.thoughtworks.tictac;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

//import java.io.PrintStream;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;

public class BoardTest {

    private Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board();
    }

    @Test
    public void shouldReturnDrawBoardWhenDrawIsCalled() {

        assertThat(board.drawBoard(), is("1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9"));
     }

    @Test
    public void shouldReturnDrawBoardWithAXOnTwoWhenDrawXIsCalled() {

        board.drawsSymbolOnBoard("2", "X");
        assertThat(board.drawBoard(), is("1|X|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9"));
     }
}