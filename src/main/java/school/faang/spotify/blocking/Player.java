package school.faang.spotify.blocking;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final Logger logger = LoggerFactory.getLogger(Player.class);
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                logger.info("Музыка воспроизводится.");
            } else {
                logger.warn("Музыка уже играет.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                logger.info("Музыка поставлена на паузу.");
            } else {
                logger.warn("Музыка уже на паузе.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            logger.info("Трек пропущен.");
        }
    }

    public void previous() {
        synchronized (lock) {
            logger.info("Вернуть к предыдущему треку.");
        }
    }

    public static void main(String[] args) {
        Player player = new Player();

        List<Thread> threads = new ArrayList<>();
        threads.add(new Thread(player::play));
        threads.add(new Thread(player::pause));
        threads.add(new Thread(player::skip));
        threads.add(new Thread(player::previous));

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                logger.error("Ошибка при ожидании завершения потока: {}", thread.getName(), e);
                Thread.currentThread().interrupt();
            }
        }
    }
}