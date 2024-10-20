package school.faang.Mnogopotochka.Synhronaized.BJS2_37164;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Music{
    private static final Logger log = LoggerFactory.getLogger(Music.class);

    public static void main(String[] args) {
        Player player = new Player();

        Thread play = new Thread(() -> {
            player.play();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                log.warn("Thread interucted", e);
            }

        });
        Thread pause = new Thread(() -> {
            player.pause();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                log.warn("Thread interucted", e);
            }

        });
        Thread skip = new Thread(() -> {
            player.skip();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                log.warn("Thread interucted", e);
            }

        });
        Thread previous = new Thread(() -> {
            player.previous();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                log.warn("Thread interucted", e);
            }

        });

        play.start();
        pause.start();
        skip.start();
        previous.start();

        try {
            play.join();
            pause.join();
            skip.join();
            previous.join();
        } catch (InterruptedException e) {
            log.warn("Thread interucted", e);
        }

    }
}
