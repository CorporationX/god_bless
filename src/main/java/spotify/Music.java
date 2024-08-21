package spotify;

import java.util.ArrayList;
import java.util.List;

public class Music {
    public static void main(String[] args) {
        List<String> songs = new ArrayList<>(List.of(
                "Maimo - Respiro", "Wilson Tunner - My Gull", "Kunst - Goatskin Server",
                "154 - Abrighterday", "Pub - Paper Aeroplane", "Gigi Masin - Cry Winds Or Flames"));
        Player player = new Player(new Object(), songs);
        Thread playThread = new Thread(() -> {
            try {
                player.play();
                Thread.sleep(800);
                player.play();
                Thread.sleep(700);
                player.play();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread pauseThread = new Thread(() -> {
            try {
                Thread.sleep(300);
                player.pause();
                Thread.sleep(700);
                player.pause();
                Thread.sleep(500);
                player.pause();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread skipThread = new Thread(() -> {
            try {
                player.skip();
                Thread.sleep(500);
                player.skip();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread prevThread = new Thread(() -> {
            try {
                Thread.sleep(300);
                player.previous();
                Thread.sleep(100);
                player.previous();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        playThread.start();
        pauseThread.start();
        skipThread.start();
        prevThread.start();
    }
}
