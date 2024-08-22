package faang.school.godbless.BJS2_24449;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var songs = new ArrayList<>(
                List.of("Not Listening - Papa Roach", "Manifesto Destiny - Patient Zero", "Loverboy - Dr. Alban",
                        "Gigi Masin - Cry Winds Or Flames")
        );
        var player = new Player(songs);
        var playThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200 * i);
                    player.play();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        var pauseThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200 * i);
                    player.pause();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        var skipThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200 * i);
                    player.skip();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        var previousThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200 * i);
                    player.previous();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();

        try {
            playThread.join();
            pauseThread.join();
            skipThread.join();
            previousThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All used player");
    }
}
