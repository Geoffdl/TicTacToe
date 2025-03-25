# Java Terminal Tic-tac-toe

A simple command-line implementation of the classic Tic-tac-toe game written in Java.

## Features

- Two-player gameplay
- Random player selection for who starts
- Input validation for moves
- Win condition checking
- Tie game detection
- Clean terminal interface

## How to Play

1. Run the game
2. Type 'yes' when asked if you want to play
3. The game will randomly select which player goes first
   - Player 1 uses 'X'
   - Player 2 uses 'O'
4. On your turn:
   - Enter a number between 1-9 to place your symbol
   - The board positions are numbered like this:
     ```
     1 | 2 | 3
     -----------
     4 | 5 | 6
     -----------
     7 | 8 | 9
     ```
5. The game ends when:
   - A player wins by getting 3 in a row (horizontal, vertical, or diagonal)
   - The board is full (tie game)

## Requirements

- Java Development Kit (JDK) 21 or higher
- Any terminal/command prompt

## Project Structure

- `TicTacToe.java` - Main
- `Game.java` - Game loop and input handling
- `Board.java` - Board representation and move handling
- `PlayerTurn.java` - Player management and move input
- `GameRules.java` - Win and tie condition checking


## How to Run

1. Compile the Java files:
   ```bash
   javac src/com/geoff/game/*.java
   ```

2. Run the game:
   ```bash
   java src/com/geoff/game/TicTacToe
   ```

## Error Handling

The game includes validation for:
- Invalid input (non-numeric values)
- Out-of-range moves (numbers not between 1-9)
- Already occupied positions

## Planned 

Moving from terminal to UI with Swing integration
