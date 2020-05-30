package com.mmr.roulette.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

@Component
public class PlayerLoader {

    @Autowired
    PlayersHandler playersHandler;

    private static final String PLAYERS_FILE = "players.txt";

    public void load(){
        try {
            File resource = new ClassPathResource(PLAYERS_FILE).getFile();
            try(Stream<String> lines = Files.lines(resource.toPath())){
                lines.forEach( line -> {
                    playersHandler.addPlayer(line);
                });
            }catch (IOException e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
