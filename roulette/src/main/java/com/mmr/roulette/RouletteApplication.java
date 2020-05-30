package com.mmr.roulette;

import com.mmr.roulette.player.PlayerLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RouletteApplication implements ApplicationRunner {

    @Autowired
    PlayerLoader playerLoader;

    public static void main(String[] args) {
        SpringApplication.run(RouletteApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        playerLoader.load();
    }
}
