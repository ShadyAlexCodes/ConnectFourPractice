package com.xanderendre.connectfour;

import java.util.Scanner;

public class Main {
    static char[][] board = new char[6][7];
    static boolean gameWon = false;

    static int turnCount = 0;

    static Scanner scanner = new Scanner(System.in);

    static Player[] player = new Player[2];

    public static void main(String[] args) {
        String name;
        char icon;
        for(int i = 0; i < player.length; i++) {
            System.out.print("Please enter a player name: ");
            name = scanner.nextLine();

            System.out.print("Please enter " + name + "'s icon: ");
            icon = scanner.nextLine().charAt(0);

            player[i] = new Player(name, icon);

        }


        for(int i = 0; i < player.length; i++) {
            System.out.println("Player: " + player[i].getPlayerName() + "  |  Icon: " + player[i].getPlayerIcon());
        }

        createBoard();
        displayBoard();

        do {
            if(turnCount == 0) {
                playTurn(player[turnCount]);
                turnCount++;
            } else if(turnCount == 1) {
                playTurn(player[turnCount]);
                turnCount--;
            } else {
                System.out.println("ERROR!");
            }
            displayBoard();
            gameWon = checkWin(player[turnCount]);
        } while (!gameWon);

    }

    private static void playTurn(Player player) {
        System.out.println();
        System.out.println("It is " + player.getPlayerName() + "(s) turn!");
        do {
            System.out.print("Enter a column number: ");
            int col = scanner.nextInt();

            // Check that the column is greater than 0 and less than 7
            if (col < 0 || col > 6) {
                System.out.println("Column must be between 0 and 7.");
                continue;
            }

            // Iterate through the total number of the rows
            for (int i = 5; i >= 0; i--) {
                // Check if the bottom (gravity) number is blank
                if (board[i][col] == ' ') {
                    // set it to x. this makes it so next iteration it'll be one less (starts at 5 then after this it'll check 4)
                    board[i][col] = player.getPlayerIcon();
                    player.setLastLocation(col);
                    // break the loop to prevent filling the board
                    return;
                }
            }

            // Inform them that the column is full
            System.out.println("The selected column " + col + " is full!");
        } while (true);
    }

    private static boolean checkWin(Player player) {
        // check 4 across
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 7; j++) {
                if(board[i][j] == player.getPlayerIcon()
                && board[i][j + 1] == player.getPlayerIcon()
                && board[i][j + 2] == player.getPlayerIcon()
                && board[i][j + 3] == player.getPlayerIcon()) {
                    System.out.println("The player " + player.getPlayerName() + " has won horizontally!");
                    return true;
                }
            }
        }

        return false;
    }

    private static void createBoard() {
        // Iterate through the rows
        for (int row = 1; row < 6; row++) {
            // Iterate through the columns
            for (int col = 1; col < 7; col++) {
                // Set the position to be blank
                board[row][col] = ' ';
            }
        }
    }

    private static void displayBoard() {
        System.out.println();
        System.out.print("     -----------------------------");
        System.out.println();
        for (int row = 1; row < 6; row++) {
            System.out.print("       | ");
            for (int col = 1; col < 7; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
            System.out.print("     -----------------------------");
            System.out.println();
        }
    }
}
















