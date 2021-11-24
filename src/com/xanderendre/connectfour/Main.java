package com.xanderendre.connectfour;

import java.util.Scanner;

public class Main {
    static String[][] board = new String[6][7];
    static boolean gameWon;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        gameWon = false;

        createBoard();
        displayBoard();

        do {
            System.out.print("Enter a column number: ");
            int col = scanner.nextInt();

            System.out.print("Enter a row number: ");
            int row = scanner.nextInt();

            System.out.println("The outputted information is col: " + col + " row: " + row);

            if (board[row][col].equals("[ ]")) {
                board[row][col] = "[x]";
                displayBoard();
            }
        } while (!gameWon);

    }

    private static void createBoard() {
        for (int row = 1; row < 6; row++) {
            for (int col = 1; col < 7; col++) {
                board[row][col] = "[ ]";
            }
        }
    }

    private static void displayBoard() {
        for (int row = 1; row < 6; row++) {
            System.out.print(row + "  ");
            for (int col = 1; col < 7; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
        System.out.print("   ");
        for (int col = 1; col < 7; col++) {
            System.out.print(col + "  ");
        }
        System.out.println();
    }
}
















