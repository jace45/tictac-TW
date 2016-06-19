package com.thoughtworks.tictac;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserTest {

    private Board board;
    private BufferedReader bufferedReader;
    private User user;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        bufferedReader = mock(BufferedReader.class);
        user = new User("User1", "X", bufferedReader, board);
    }

    @Test
    public void shouldLetUserDrawSymbolOnBoard() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2");

        user.userPlaysTheirSymbol();

        verify(board).drawsSymbolOnBoard("2","X");
    }

    @Test
    public void getName() throws Exception {

    }

    @Test
    public void shouldCheckIfChoiceIsAValidMoveWhenChoosingLocation() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2");

        user.userPlaysTheirSymbol();

        verify(board).isNotAValidMove("2");
     }


}