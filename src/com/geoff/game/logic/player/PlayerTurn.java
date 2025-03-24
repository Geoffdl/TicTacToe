package com.geoff.game.logic.player;

import com.geoff.game.board.Board;

import java.util.Random;
import java.util.Scanner;

/**
 * PLayerTurn()
 * getMove()
 * isValidMove()
 * getCurrentPlayerSymbol()
 * switchPlayer()
 */
//handles player switching and moves

public class PlayerTurn {

    private final Scanner scanner;
    private boolean startingPlayer;
    private boolean currentPlayerIsOne;

    public PlayerTurn() {

        scanner = new Scanner(System.in);
        Random random = new Random();

        currentPlayerIsOne = random.nextBoolean();
        String startingPlayer = currentPlayerIsOne ? "Player 1 (X)" : "Player 2 (O)";
        System.out.println("\n" + startingPlayer + " starts!");
    }

    public String getMove(Board board) {
        int position;

        do {
            System.out.println("Current player: " + (currentPlayerIsOne ? "Player 1 (X)" : "Player 2 (O)"));
            System.out.print("Enter position (1-9): ");

            while (!scanner.hasNextInt()) {
                System.out.println("\nThat's not a valid number! Please enter a number between 1 and 9");
                scanner.next(); // clear the invalid input
                System.out.print("Enter position (1-9): ");
            }

            position = scanner.nextInt();

            if (isValidMove(position, board)) {
                System.out.println("\nInvalid move! Position already taken or out of range.");
            }
        } while (isValidMove(position, board));

        // Convert position 1-9 to row/col
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;
        return row + "," + col + "," + getCurrentPlayerSymbol();
    }

    private boolean isValidMove(int position, Board board) {

        if (position < 1 || position > 9) {
            return true;
        }
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;

        return !board.isCellEmpty(row, col);

    }

    public String getCurrentPlayerSymbol() {
        String player1Symbol = "X";
        String getPlayer2Symbol = "O";
        return currentPlayerIsOne ? player1Symbol : getPlayer2Symbol;
    }

    public void switchPlayer() {
        currentPlayerIsOne = !currentPlayerIsOne;
    }
}