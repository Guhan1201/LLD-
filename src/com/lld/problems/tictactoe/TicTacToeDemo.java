package com.lld.problems.tictactoe;

import java.util.Scanner;

/**
 * Tic-Tac-Toe Game Demo with Interactive Console Interface
 */
public class TicTacToeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        System.out.println("========================================");
        System.out.println("  Welcome to Tic-Tac-Toe Game (LLD)");
        System.out.println("========================================\n");

        while (playAgain) {
            runGame(scanner);

            System.out.println("\nDo you want to play again? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }

        System.out.println("\nThank you for playing! Goodbye!");
        scanner.close();
    }




    /**
     * Run a single game of Tic-Tac-Toe
     */
    private static void runGame(Scanner scanner) {
        System.out.println("\nEnter Player X name: ");
        String playerXName = scanner.nextLine().trim();
        if (playerXName.isEmpty()) {
            playerXName = "Player X";
        }

        System.out.println("Enter Player O name: ");
        String playerOName = scanner.nextLine().trim();
        if (playerOName.isEmpty()) {
            playerOName = "Player O";
        }

        TicTacToe game = new TicTacToe(playerXName, playerOName);

        System.out.println("\n--- Game Started ---");
        System.out.println("Board positions (0-indexed):");
        System.out.println(" 0 | 1 | 2");
        System.out.println("-----------");
        System.out.println(" 3 | 4 | 5");
        System.out.println("-----------");
        System.out.println(" 6 | 7 | 8");

        while (!game.isGameOver()) {
            game.displayGameStatus();

            System.out.println(game.getCurrentPlayer().getName() + ", enter your move (0-8) or -1 to quit: ");
            String input = scanner.nextLine().trim();

            if (input.equals("-1")) {
                System.out.println("Game abandoned!");
                return;
            }

            try {
                int position = Integer.parseInt(input);
                if (position < 0 || position > 8) {
                    System.out.println("Invalid position! Please enter a number between 0 and 8.");
                    continue;
                }

                int row = position / 3;
                int col = position % 3;

                if (!game.makeMove(row, col)) {
                    System.out.println("Move failed. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }

        // Game Over - Display Results
        displayGameResults(game);
    }

    /**
     * Display the final game results
     */
    private static void displayGameResults(TicTacToe game) {
        game.displayGameStatus();

        GameState state = game.getGameState();
        System.out.println("\n========================================");
        switch (state) {
            case PLAYER_X_WINS:
                System.out.println("🎉 " + game.getPlayerX().getName() + " (X) WINS! 🎉");
                break;
            case PLAYER_O_WINS:
                System.out.println("🎉 " + game.getPlayerO().getName() + " (O) WINS! 🎉");
                break;
            case DRAW:
                System.out.println("🤝 It's a DRAW! 🤝");
                break;
            default:
                break;
        }
        System.out.println("========================================");
    }
}

