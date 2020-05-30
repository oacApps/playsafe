package com.mmr.roulette.bet;

import com.mmr.roulette.enums.PlayerInput;
import com.mmr.roulette.player.Player;
import com.mmr.roulette.player.PlayersHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class BetHandler {

    @Autowired
    PlayersHandler playersHandler;

    public List<PlayerBet> playerBets = new ArrayList<>();

    public void collectBet(){
        Scanner keyboard = new Scanner(System.in);
        int numberOfBet = -1;
        String userInput[];

        for (Player player : playersHandler.getPlayers()) {
            System.out.print("\nPlease enter number of bet for player " + player.getName() + " : ");
            numberOfBet = keyboard.nextInt();
            keyboard.nextLine();
            while (numberOfBet > 0) {
                System.out.print(player.getName() + " ");
                userInput = keyboard.nextLine().split(" ");
                this.playerBets.add(createBet(player.getName(), userInput[PlayerInput.PLAYERS_BET.getPlayerInput()], userInput[PlayerInput.BET_AMOUNT.getPlayerInput()]));
                numberOfBet--;
            }

        }
        keyboard.close();
    }

    private PlayerBet createBet(String playerName, String betNumber, String betAmount){
        return new PlayerBet(new Player(playerName), new Bet(betNumber, Double.valueOf(betAmount)));
    }
}
