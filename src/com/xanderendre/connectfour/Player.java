package com.xanderendre.connectfour;

public class Player {

    private String playerName;
    private char playerIcon;
    private int lastLocation;


    public Player(String playerName, char playerIcon) {
        this.playerName = playerName;
        this.playerIcon = playerIcon;
    }

    public Player(String playerName, int lastLocation) {
        this.playerName = playerName;
        this.lastLocation = lastLocation;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getLastLocation() {
        return lastLocation;
    }

    public void setLastLocation(int lastLocation) {
        this.lastLocation = lastLocation;
    }

    public char getPlayerIcon() {
        return playerIcon;
    }

    public void setPlayerIcon(char playerIcon) {
        this.playerIcon = playerIcon;
    }

}
