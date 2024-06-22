package faang.school.godbless.spotify_blocking;

import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        List<String> playList = List.of("track 1", "track 2", "track 3", "track 4", "track 5");

        Thread playThread = new Thread(() -> {
            try {
                player.play(playList.get(1));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread pauseThread = new Thread(() -> {
            try {
                player.pause(playList.get(0));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread skipThread = new Thread(() -> {
            try {
                player.skip(playList.get(3));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread previousThread = new Thread(() -> {
            try {
                player.previous(playList.get(4));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }
}
