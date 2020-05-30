package com.mmr.roulette.game;

import com.mmr.roulette.bet.BetHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Roulette {

    private static final String BALL_LANDING_TIME = "${ball.landing.time}";

    @Autowired
    BetHandler betHandler;

    @Scheduled(fixedRateString = BALL_LANDING_TIME, initialDelayString = BALL_LANDING_TIME)
    public void run(){

        betHandler.collectBet();
        int rouletteNumber = rollTheBall();
        System.out.println("Number : " + rouletteNumber);
        winningsCalculate(rouletteNumber);
        publishResult();

        System.out.println("\n\nPlease wait ! game will run in 30 second.\n\n");
    }
    private void publishResult(){
        System.out.println("Players      Bet     Outcome     Winnings" );
        System.out.println("--------" );
        betHandler.playerBets.forEach( playerBet ->{
            StringBuilder sb = new StringBuilder();
            sb.append(playerBet.getPlayer().getName()).append("    ")
                    .append(playerBet.getBet().getBetNumber()).append("    ")
                    .append(playerBet.getBet().getOutcome()).append("    ")
                    .append(playerBet.getBet().getWinnings());
            System.out.println(sb.toString());
        });

    }

    private void winningsCalculate(int rouletteNumber){
        betHandler.playerBets.forEach(playerBet -> {
            double cal = calculator(playerBet.getBet().getBetNumber(), playerBet.getBet().getAmount(), rouletteNumber);
            playerBet.getBet().setWinnings(cal);
            playerBet.getBet().setOutcome(playerBet.getBet().getAmount() > cal ? "LOSE" : "WIN");
        });
    }

    private double calculator(String bet, Double amount, int rouletteNumber){
        double win = 0.0;
        int oddEven = rouletteNumber % 2;
        if(("ODD".equals(bet.toUpperCase()) && oddEven ==1) || ("EVEN".equals(bet.toUpperCase()) && oddEven ==0) ) {
            win = amount * 2;
        } else if(("ODD".equals(bet.toUpperCase()) && oddEven ==0) || ("EVEN".equals(bet.toUpperCase()) && oddEven ==1) ) {
            win = amount * 0;
        }else if(Integer.valueOf(bet) == rouletteNumber) {
            win = amount * 36;
        }

        return win;
    }

    private int rollTheBall(){
        System.out.println("\nThe ball is landing .... \n");
        Random random = new Random();
        return random.nextInt(37);
    }
}
