package school.faang;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.Random;

@Getter
public abstract class PigThread extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(PigThread.class);
    private static final Random random = new Random();

    private final String pigName;
    private final String material;
    private final int minBuildingTime;
    private final int maxBuildingTime;

    public PigThread(String pigName, String material, int minBuildingTime, int maxBuildingTime) {
        isValidString(pigName, "Pig name");
        isValidString(material, "Material");
        this.pigName = pigName;
        this.material = material;
        this.minBuildingTime = minBuildingTime;
        this.maxBuildingTime = maxBuildingTime;
    }

    private void isValidString(String string, String message) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException(message + " can't be null or empty.");
        }
    }

    @Override
    public void run() {
        logger.info("{} started building the house using {} at {}",
                pigName, material, Instant.now());
        try {
            Thread.sleep(minBuildingTime + random.nextInt(maxBuildingTime - minBuildingTime));
        } catch (InterruptedException e) {
            logger.info("{} failed building the house using {} at {}",
                    pigName, material, Instant.now());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        logger.info("{} finished building the house using {} at {}",
                pigName, material, Instant.now());
    }
}
