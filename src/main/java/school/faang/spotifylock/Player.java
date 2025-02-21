package school.faang.spotifylock;

import java.util.logging.Logger;

public class Player {
    private static final Logger LOGGER = Logger.getLogger(Player.class.getName());
    private final Object lock;
    private boolean isPlaying;

    public Player() {
        lock = new Object();
        isPlaying = false;
    }

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
            }
            LOGGER.info(Thread.currentThread().getName() + "\n Music is play\n" +
                    " isPlaying flag: " + isPlaying);
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
            }
            LOGGER.info(Thread.currentThread().getName() + "\n Music is paused\n" +
                    " isPlaying flag: " + isPlaying);
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                LOGGER.info(Thread.currentThread().getName() +
                        " \nisPlaying flag: " + isPlaying + "\n Music is skipped");
            } else {
                LOGGER.info(Thread.currentThread().getName() + "\n Player is not play!");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                LOGGER.info(Thread.currentThread().getName() +
                        " \nisPlaying flag: " + isPlaying + " Player is previous");
            } else {
                LOGGER.info(Thread.currentThread().getName() + "\n Player is not play!");
            }
        }
    }
}
