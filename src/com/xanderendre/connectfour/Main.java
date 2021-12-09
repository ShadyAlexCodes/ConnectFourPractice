package com.xanderendre.connectfour;

import java.util.Scanner;

public class Main {
    static boolean gameStarted = false;

    static int turnCount = 0, colFull = 0;

    static Scanner scanner = new Scanner(System.in);

    static Player[] player = new Player[2];

    static Board board = new Board();

    public static void main(String[] args) {
        System.out.println("          CONNECT FOUR\n  -----------------------------");
        System.out.println("        Choose a game type!\n\n  - Player versus Player (PVP)\n  - Player versus Computer (PVC)\n  - Computer versus Computer (CVC)\n\n  -----------------------------");
        System.out.print("Enter a game type: ");
        String gameType, name;
        char icon;

        // Run the program while gameStarted != true.

        do {
            // Grab the input from the scanner
            gameType = scanner.nextLine();
            switch (gameType) {
                case "pvp":
                case "PVP":
                    try {
                        // Wait 2 seconds before printing information
                        Thread.sleep(2000);
                        // Iterate through the total number of players defined in the array above
                        for (int i = 0; i < player.length; i++) {

                            // Ask for their name
                            System.out.print("Please enter a player name: ");
                            // Store their name
                            name = scanner.nextLine();

                            // Ask for their icon
                            System.out.print("Please enter " + name + "'s icon: ");
                            // Check their icon
                            icon = scanner.nextLine().charAt(0);

                            // Define the player at the position
                            player[i] = new Player(name, icon);
                        }
                    } catch (Exception ex) {
                        // Catch errors.
                        System.out.println("Error generated: " + ex);
                    }
                    // Break the loop and start the game.
                    gameStarted = true;
                    break;
                case "pvc":
                case "PVC":
                    try {
                        // Wait 2 seconds before printing information
                        Thread.sleep(2000);
                        // Ask for their name
                        System.out.print("Please enter a player name: ");
                        // Store their name
                        name = scanner.nextLine();
                        // Ask for their icon
                        System.out.print("Please enter " + name + "'s icon: ");
                        // Store their icon based on the first character
                        icon = scanner.nextLine().charAt(0);

                        // Define the player as player 1
                        player[0] = new Player(name, icon);
                        // Create the Computer player and assign it an icon
                        player[1] = new Player("Computer", '*');
                    } catch (Exception ex) {
                        // Catch errors
                        System.out.println("Error generated: " + ex);
                    }
                    // Break the loop and start the game.
                    gameStarted = true;
                    break;
                case "cvc":
                case "CVC":
                    try {
                        // Wait 2 seconds before printing information
                        Thread.sleep(2000);
                        // Define the first Computer Player
                        player[0] = new Player("Computer 1", '-');
                        // Define the second Computer Player
                        player[1] = new Player("Computer 2", '*');
                    } catch (Exception ex) {
                        // Catch errors
                        System.out.println("Error generated: " + ex);
                    }
                    // Break the loop and start the game.
                    gameStarted = true;
                    break;
                case "exit":
                case "EXIT":
                    // check if the user wishes to end the game.
                    System.out.println("A game of connect four has been ended.");
                    System.exit(0);
                    break;
                default:
                    // Inform the user they did not input a valid game.
                    System.out.print("That was not a valid game type...\nEnter a game type: ");
                    gameStarted = false;
                    break;
            }
        } while (!gameStarted);

        // Fill the board
        board.fillBoard();
        // Display the board for visualization
        board.displayBoard();

        // Run while the game is started
        do {
            // Check if the game type is player versus player
            if (gameType.equalsIgnoreCase("pvp")) {
                // Check the current turn counter
                if (turnCount == 0) {
                    // Execute players turn based on the position of the player. Mark that it is not the computer
                    playTurn(player[turnCount], false);
                    // Check if the player has won the game
                    gameStarted = checkWin(player[turnCount]);
                    // Set the turn value to 1 so the other player runs.
                    turnCount = 1;
                } else if (turnCount == 1) {
                    // Execute players turn based on the position of the player. Mark that it is not the computer.
                    playTurn(player[turnCount], false);
                    // Check if the player has won the game
                    gameStarted = checkWin(player[turnCount]);
                    // Set the turn value back to 0 so the first player runs again
                    turnCount = 0;
                } else {
                    // Inform them of an error
                    System.err.println("There was an error playing a Player versus Player match.");
                }
            }
            // Check if the game type is player versus computer
            else if (gameType.equalsIgnoreCase("pvc")) {
                // Check the current turn counter
                if (turnCount == 0) {
                    // Execute players turn based on the position of the player. Mark that it is not the computer
                    playTurn(player[turnCount], false);
                    // Check if the player has won the game
                    gameStarted = checkWin(player[turnCount]);
                    // Set the turn value to 1 so the computer runs
                    turnCount = 1;
                } else if (turnCount == 1) {
                    // Execute players turn based on the position of the player. Mark that IT IS THE COMPUTER!!
                    playTurn(player[turnCount], true);
                    // Check if the computer won the game
                    gameStarted = checkWin(player[turnCount]);
                    // Reset the turn counter back to 0 to let the player run
                    turnCount = 0;
                } else {
                    // Inform them of an error
                    System.err.println("There was an error playing a Player versus Computer match.");
                }
            }
            // Check if the game type is computer versus computer
            else if (gameType.equalsIgnoreCase("cvc")) {
                // Check the turn counter
                if (turnCount == 0) {
                    // Execute the computers turn based on the position. Mark the playTurn as a computer!
                    playTurn(player[turnCount], true);
                    // Automate real playtime
                    try {
                        // Wait 2 seconds
                        Thread.sleep(0000);
                        // Check if the computer won the game
                        gameStarted = checkWin(player[turnCount]);
                    } catch (Exception ex) {
                        // Print any exceptions
                        System.out.println("Error: " + ex);
                    }
                    // Set the turn value to 1 so the other computer runs
                    turnCount = 1;
                } else if (turnCount == 1) {
                    // Execute the computers turn based on the position. Mark the playTurn as a computer!
                    playTurn(player[turnCount], true);
                    // Automate real playtime, again
                    try {
                        // Wait 2 seconds
                        Thread.sleep(0000);
                        // check if the computer won the game
                        gameStarted = checkWin(player[turnCount]);
                    } catch (Exception ex) {
                        // Spit out exceptions
                        System.out.println("Error: " + ex);
                    }
                    // Return the turn counter
                    turnCount = 0;
                } else {
                    // Inform them of error
                    System.err.println("There was an error playing a Computer versus Computer match.");
                }
            }

            // Print the board
            board.displayBoard();

        } while (!gameStarted);

    }


    private static void playTurn(Player player, boolean computer) {
        System.out.println();
        System.out.println("It is " + player.getPlayerName() + "(s) turn!");
        do {
            System.out.print("Enter a column number: ");
            int col;
            if (computer) {
                col = board.generateRandomNumber(1, 6);
                System.out.print(col + "\n");
            } else {
                col = scanner.nextInt();
            }


            // Check that the column is greater than 0 and less than 7
            if (col < 1 || col > 6) {
                System.out.println("Column must be between 1 and 6.");
                continue;
            }

            // Iterate through the total number of the rows
            for (int i = 5; i >= 0; i--) {
                // Check if the bottom (gravity) number is blank
                if (board.getBoard()[i][col] == ' ') {
                    // set it to x. this makes it so next iteration it'll be one less (starts at 5 then after this it'll check 4)
                    board.getBoard()[i][col] = player.getPlayerIcon();
                    player.setLastLocation(col);
                    // break the loop to prevent filling the board
                    return;
                }
            }

            // Inform them that the column is full
            colFull++;
            System.out.println("The selected column " + col + " is full!");
        } while (true);
    }

    private static boolean checkWin(Player player) {
        // check 4 across
        System.out.println("CURRENT PLAYER: " + player.getPlayerName());
        System.out.println("CURRENT ICON: " + player.getPlayerIcon());
        if (colFull == 6) {
            System.out.println("THE GAME WAS UNBEATABLE");
            return true;
        }

        for (int row = 0; row < board.getBoard().length; row++) {
            for (int col = 0; col < board.getBoard()[0].length - 3; col++) {
                if (board.getBoard()[row][col] == player.getPlayerIcon()
                        && board.getBoard()[row][col + 1] == player.getPlayerIcon()
                        && board.getBoard()[row][col + 2] == player.getPlayerIcon()
                        && board.getBoard()[row][col + 3] == player.getPlayerIcon()) {
                    System.out.println("The player " + player.getPlayerName() + " has won horizontally!");
                    return true;
                }
            }
        }

        for (int row = 0; row < board.getBoard().length - 3; row++) {
            for (int col = 0; col < board.getBoard()[0].length; col++) {
                if (board.getBoard()[row][col] == player.getPlayerIcon()
                        && board.getBoard()[row + 1][col] == player.getPlayerIcon()
                        && board.getBoard()[row + 2][col] == player.getPlayerIcon()
                        && board.getBoard()[row + 3][col] == player.getPlayerIcon()) {
                    System.out.println("The player " + player.getPlayerName() + " has won vertically!");
                    return true;
                }
            }
        }

        // Downward Diagonal
        for (int row = 0; row < board.getBoard().length - 3; row++) {
            for (int col = 0; col < board.getBoard()[0].length - 3; col++) {
                if (board.getBoard()[row][col] == player.getPlayerIcon()
                        && board.getBoard()[row + 1][col + 1] == player.getPlayerIcon()
                        && board.getBoard()[row + 2][col + 2] == player.getPlayerIcon()
                        && board.getBoard()[row + 3][col + 3] == player.getPlayerIcon()) {
                    System.out.println("The player " + player.getPlayerName() + " has won diagonally!");
                    return true;
                }
            }
        }

        // Upward Diagonal
        for (int row = 3; row < board.getBoard().length; row++) {
            for (int col = 0; col < board.getBoard()[0].length - 3; col++) {
                if (board.getBoard()[row][col] == player.getPlayerIcon()
                        && board.getBoard()[row - 1][col + 1] == player.getPlayerIcon()
                        && board.getBoard()[row - 2][col + 2] == player.getPlayerIcon()
                        && board.getBoard()[row - 3][col + 3] == player.getPlayerIcon()) {
                    System.out.println("The player " + player.getPlayerName() + " has won diagonally!");
                    return true;
                }
            }
        }
        return false;
    }
}






