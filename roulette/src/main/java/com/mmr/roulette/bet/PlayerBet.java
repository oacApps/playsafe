package com.mmr.roulette.bet;

import com.mmr.roulette.player.Player;
import lombok.Data;

@Data
public class PlayerBet {
    private Player player;
    private Bet bet;

    public PlayerBet(Player player, Bet bet){
        this.player = player;
        this.bet = bet;
    }
}
