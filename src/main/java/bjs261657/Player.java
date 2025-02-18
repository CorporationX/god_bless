package bjs261657;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Player implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Player.class);
    private final List<String> compositions = new ArrayList<>();
    private static int compositionNumber = 0;
    private String currentComposition;
    final Object lock = new Object();
    boolean isPlaying = false;

    public void play() throws InterruptedException {
        synchronized (lock) {
            isPlaying = true;
            validateCompositionNumber(compositionNumber);
            LOGGER.info("User {} has turned on the music ", Thread.currentThread().getName());
            LOGGER.info("Listening {} ", compositions.get(compositionNumber));
            Thread.sleep(1000);
            pause();
            LOGGER.info("User {} has turned off the music", Thread.currentThread().getName());
            lock.wait();
        }
    }

    public void pause() throws InterruptedException {
        synchronized (lock) {
            isPlaying = false;
            lock.notify();
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

    }

    private void validateCompositionNumber(int compositionNumber) {
        if (compositionNumber >= compositions.size()) {
            compositionNumber = (compositions.size()) % compositionNumber;
        }
        if (compositionNumber < 0) {
            compositionNumber = (compositionNumber + compositions.size()) % 26;
        }
        Player.compositionNumber = compositionNumber;
    }
}
