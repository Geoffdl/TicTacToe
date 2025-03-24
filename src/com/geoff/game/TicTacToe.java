package com.geoff.game;

import com.geoff.game.board.Board;
import com.geoff.game.logic.player.PlayerTurn;
import com.geoff.game.logic.rules.GameRules;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Board board = new Board();
        board.drawBoard();
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = false;

        System.out.print("(yes/no): ");
        String startChoice = scanner.next().trim().toLowerCase();
        if (startChoice.equals("yes")) {
            gameRunning = true;
        }

        PlayerTurn playerTurn = new PlayerTurn();

        while (gameRunning) {
            board.drawBoard();

            String move = playerTurn.getMove(board);

            String[] moveData = move.split(",");
            int row = Integer.parseInt(moveData[0]);
            int col = Integer.parseInt(moveData[1]);
            String symbol = moveData[2];

            board.makeMove(row, col, symbol);

            if (GameRules.isWon(board) || GameRules.isFull(board)) {
                board.drawBoard();
                gameRunning = false;
                continue;
            }
            playerTurn.switchPlayer();
        }
    }

}