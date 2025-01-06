package school.faang.task47602;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class Trial implements Runnable {
    private final Logger logger = LoggerFactory.getLogger(Trial.class);
    private static final Random RAND = new Random();

    private final String knightName;
    private final String trialName;

    @Override
    public void run() {
        System.out.printf("%s начал испытание %s%n", knightName, trialName);
        try {
            TimeUnit.SECONDS.sleep(RAND.nextInt(5));
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }
}
