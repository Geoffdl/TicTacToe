package com.geoff.game.logic.rules;

import com.geoff.game.board.Board;

public class GameRules {

    private GameRules() {
    }

    public static boolean isWon(Board board) {
        String[][] grid = board.getGrid();

        // Check rows
        for (int row = 0; row < 3; row++) {
            if (grid[row][0].equals(grid[row][1]) &&
                    grid[row][1].equals(grid[row][2]) &&
                    !grid[row][0].equals(" ")) {
                System.out.println("Player " + grid[row][0] + " wins!");
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (grid[0][col].equals(grid[1][col]) &&
                    grid[1][col].equals(grid[2][col]) &&
                    !grid[0][col].equals(" ")) {
                System.out.println("\nPlayer " + grid[0][col] + " wins!");
                return true;
            }
        }

        // Check diagonals
        if (grid[0][0].equals(grid[1][1]) &&
                grid[1][1].equals(grid[2][2]) &&
                !grid[0][0].equals(" ")) {
            System.out.println("\nPlayer " + grid[0][0] + " wins!");
            return true;
        }

        if (grid[0][2].equals(grid[1][1]) &&
                grid[1][1].equals(grid[2][0]) &&
                !grid[0][2].equals(" ")) {
            System.out.println("\nPlayer " + grid[0][2] + " wins!");
            return true;
        }

        return false; // No winner yet
    }

    public static boolean isFull(Board board) {
        String[][] grid = board.getGrid();


        boolean isBoardFull = true;


        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (grid[row][col].equals(" ")) {
                    isBoardFull = false;
                    return false;
                }
            }
        }


        if (isBoardFull) {
            System.out.println("\nIt's a tie!");
        }

        return isBoardFull;
    }
}