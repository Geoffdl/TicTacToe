package com.geoff.game.logic;
import com.geoff.game.board.Board;
import com.geoff.game.logic.player.PlayerTurn;
import com.geoff.game.logic.rules.GameRules;
import java.util.Scanner;

/**
 * start()
 * initializeGame()
 * playGame()
 * playTurn()
 * processMove()
 * isGameOver()
 * askForReplay()
 * endGame()
 */

public class Game {
    private Board board;
    private PlayerTurn playerTurn;
    private final Scanner scanner;
    private boolean gameRunning;

    public Game() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean wantToPlay = true;

        while (wantToPlay) {
            initializeGame();
            playGame();
            wantToPlay = askForReplay();
        }

        endGame();
    }

    private void initializeGame() {
        this.board = new Board();
        this.board.drawBoard();


        System.out.print("(yes/no): ");
        String startChoice = scanner.next().trim().toLowerCase();
        this.gameRunning = startChoice.equals("yes");
        this.playerTurn = new PlayerTurn();
    }

    private void playGame() {
        while (gameRunning) {
            playTurn();

            if (isGameOver()) {
                board.drawBoard();
                gameRunning = false;
            } else {
                playerTurn.switchPlayer();
            }
        }
    }

    private void playTurn() {
        board.drawBoard();
        String move = playerTurn.getMove(board);
        processMove(move);
    }

    private void processMove(String move) {
        String[] moveData = move.split(",");
        int row = Integer.parseInt(moveData[0]);
        int col = Integer.parseInt(moveData[1]);
        String symbol = moveData[2];

        board.makeMove(row, col, symbol);
    }

    private boolean isGameOver() {
        return GameRules.isWon(board) || GameRules.isFull(board);
    }

    private boolean askForReplay() {
        System.out.print("\nWould you like to play again? (yes/no): ");
        String replayChoice = scanner.next().trim().toLowerCase();
        return replayChoice.equals("yes");
    }

    private void endGame() {
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}