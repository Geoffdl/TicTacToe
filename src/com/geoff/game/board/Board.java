package com.geoff.game.board;

import java.util.Objects;

/**
 * drawBoard()
 * initBoard()
 * getGrid()
 * makeMove()
 * isCellEmpty()
 */

public class Board {

    private String[][] grid;
    private static final int SIZE = 3;
    private static final String EMPTY = " ";

    public Board() {
        System.out.println("\nWelcome to the TicTacToe super terminal gaming. Wanna play?");
        initBoard();
    }

    private void initBoard() {
        grid = new String[SIZE][SIZE];

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                grid[row][col] = EMPTY;
            }
        }
    }

    public void drawBoard() {

        System.out.println("_____________");
        for (int row = 0; row < SIZE; row++) {
            printLine(grid[row]);
            System.out.println("-------------");
        }
    }

    public static void printLine(String[] line) {
        System.out.print("| ");
        for (String cell : line) {
            System.out.print(cell + " | ");
        }
        System.out.println();
    }

    public void makeMove(int row, int col, String symbol) {

        if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && grid[row][col].equals(EMPTY)) {
            grid[row][col] = symbol;
        }
    }

    public String[][] getGrid() {
        return grid;
    }

    public boolean isCellEmpty(int row, int col) {

        if (Objects.equals(grid[row][col], "X") || Objects.equals(grid[row][col], "O")) {
            return false;
        } else {
            return true;
        }
    }
}