package bjs261657;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Player implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Player.class);
    private static final int TASK_DELAY_MS = 1000;
    private final List<String> compositions = new ArrayList<>();
    private int compositionNumber = 0;
    private String currentComposition;
    private final Object lock = new Object();
    boolean isPlaying = false;

    public void play() throws InterruptedException {
        synchronized (lock) {
            isPlaying = true;
            validateCompositionNumber(compositionNumber);
            LOGGER.info("User {} has turned on the music ", Thread.currentThread().getName());
            LOGGER.info("Listening {} ", compositions.get(compositionNumber));
            Thread.sleep(TASK_DELAY_MS);
            pause();
        }
    }

    public void pause() throws InterruptedException {
        synchronized (lock) {
            isPlaying = false;
            LOGGER.info("User {} has turned off the music", Thread.currentThread().getName());
            lock.notify();
            lock.wait();
        }
    }

    public void skip() throws InterruptedException {
        synchronized (lock) {
            validateCompositionNumber(compositionNumber + 1);
            currentComposition = compositions.get(compositionNumber);
            LOGGER.info("User {} has switched it on next composition", Thread.currentThread().getName());
            play();
        }
    }

    public void previous() throws InterruptedException {
        synchronized (lock) {
            validateCompositionNumber(compositionNumber - 1);
            currentComposition = compositions.get(compositionNumber);
            LOGGER.info("User {} has switched it on previous composition", Thread.currentThread().getName());
            play();
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(TASK_DELAY_MS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void validateCompositionNumber(int compositionNumber) {
        if (compositionNumber >= compositions.size()) {
            this.compositionNumber = (compositions.size()) % compositionNumber;
        } else if (compositionNumber < 0) {
            this.compositionNumber = (compositionNumber + compositions.size()) % compositions.size();
        }
    }
}
