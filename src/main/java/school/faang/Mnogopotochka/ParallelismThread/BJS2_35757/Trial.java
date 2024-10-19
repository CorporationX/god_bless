package school.faang.Mnogopotochka.ParallelismThread.BJS2_35757;

import lombok.AllArgsConstructor;

import java.util.logging.Level;
import java.util.logging.Logger;

@AllArgsConstructor
public class Trial implements Runnable{
    private static final Logger logger = Logger.getLogger(Trial.class.getName());
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        logger.info(knightName + " начал испытание: " + trialName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logger.log(Level.WARNING, "Thread interrupted: " + Thread.currentThread(), e);
            Thread.currentThread().interrupt();
        }
        logger.info(knightName + " закончил испытание: " + trialName);
    }
}
