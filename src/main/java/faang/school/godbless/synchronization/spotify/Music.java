package faang.school.godbless.synchronization.spotify;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = new Thread(player::play);
        Thread pauseThread = new Thread(player::pause);
        Thread skipThread = new Thread(player::skip);
        Thread previousThread = new Thread(player::previous);

        log.info("Starting the player. Playing state: " + player.isPlaying());

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.warn("Main thread was interrupted.", e);
        }

        log.info("Turning off the player.");
    }
}
