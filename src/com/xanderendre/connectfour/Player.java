package com.xanderendre.connectfour;

public class Player {

    private String playerName;
    private int lastLocation;

    public Player(String playerName) {
        this.playerName = playerName;
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
}
