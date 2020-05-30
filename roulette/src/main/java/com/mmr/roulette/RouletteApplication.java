package com.mmr.roulette;

import com.mmr.roulette.game.Roulette;
import com.mmr.roulette.player.PlayerLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class RouletteApplication implements ApplicationRunner {

    @Autowired
    PlayerLoader playerLoader;

    @Autowired
    Roulette roulette;

    public static void main(String[] args) {
        SpringApplication.run(RouletteApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        playerLoader.load();
        roulette.run();
    }
}
