package com.mmr.roulette.bet;

import lombok.Data;

@Data
public class Bet {
    private String betNumber;
    private double amount;
    private String outcome;
    private double winnings;

    public Bet(String betNumber, double amount){
        this.betNumber = betNumber;
        this.amount = amount;
    }
}
