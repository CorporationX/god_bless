package org.example.model.spotifyBlocking;

import java.util.ArrayList;
import java.util.List;

public class Music {
    public static void main(String[] args) {
        List<String> musics = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            musics.add(String.format("{music %d}", i));
        }
        Player player = new Player(musics);

        Thread play = new Thread(player::play);
        Thread pause = new Thread(player::pause);
        Thread next = new Thread(player::skip);
        Thread previous = new Thread(player::previous);

        play.start();
        pause.start();
        previous.start();
        next.start();
    }
}
