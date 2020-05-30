package com.mmr.roulette.player;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlayersHandler {

    private List<Player> players = new ArrayList<>();

    public void addPlayer(String playerName){
        players.add(new Player(playerName));
    }

    public List<Player> getPlayers(){
        return this.players;
    }
}
