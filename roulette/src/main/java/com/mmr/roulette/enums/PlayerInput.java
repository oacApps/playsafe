package com.mmr.roulette.enums;

public enum PlayerInput {

    PLAYERS_BET(0),
    BET_AMOUNT(1);

    private final int playerInput;

    PlayerInput(int playerInput) {
        this.playerInput = playerInput;
    }

    public int getPlayerInput() {
        return playerInput;
    }
}
