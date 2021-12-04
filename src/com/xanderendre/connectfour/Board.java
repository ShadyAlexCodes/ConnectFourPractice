package com.xanderendre.connectfour;

public class Board {

    private final char[][] board = new char[6][7];

    public char[][] getBoard() {
        return board;
    }

    public void displayBoard() {
        System.out.println();
        System.out.println("         1   2   3   4   5   6");
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

    public void fillBoard() {
        // Iterate through the rows
        for (int row = 1; row < 6; row++) {
            // Iterate through the columns
            for (int col = 1; col < 7; col++) {
                // Set the position to be blank
                board[row][col] = ' ';
            }
        }
    }

    public int generateRandomNumber(int min, int max) {
        // Generate a random number in the inclusivity range of the min and max
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

}
