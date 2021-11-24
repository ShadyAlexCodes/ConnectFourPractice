package com.xanderendre.connectfour;

import java.util.Scanner;

public class Main {
    static char[][] board = new char[6][7];
    static boolean gameWon;

    static int turnCount = 0;

    static Scanner scanner = new Scanner(System.in);

    static Player[] player = new Player[2];

    public static void main(String[] args) {

        gameWon = false;
        int position = 0;
        do {
            System.out.print("Please enter a player name: ");
            String name = scanner.nextLine();
            player[position] = new Player(name);
            position++;
        } while (position < 2);


        for(int i = 0; i < player.length; i++) {
            System.out.println("Player: " + player[i].getPlayerName());
        }


        createBoard();
        displayBoard();

        do {
            if(turnCount == 0) {
                playTurn('x', player[turnCount].getPlayerName());
                turnCount++;
            } else if(turnCount == 1) {
                playTurn('o', player[turnCount].getPlayerName());
                turnCount--;
            } else {
                System.out.println("ERROR!");
            }
            displayBoard();
        } while (!gameWon);

    }

    private static void playTurn(char icon, String player) {
        System.out.println();
        System.out.println("It is " + player + "(s) turn!");
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
                    board[i][col] = icon;
                    // break the loop to prevent filling the board
                    return;
                }
            }

            // Inform them that the column is full
            System.out.println("The selected column " + col + " is full!");
        } while (true);
    }

    private static void createBoard() {
        for (int row = 1; row < 6; row++) {
            for (int col = 1; col < 7; col++) {
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
















