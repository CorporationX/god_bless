package school.faang;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.faang.utils.ValidationUtil;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
public class RocketLaunch {
    private static final Logger logger = LoggerFactory.getLogger(RocketLaunch.class);
    private static final int ROCKET_START_LATENCY = 1000;
    private final String name;
    private final LocalDateTime startTime;

    public RocketLaunch(String name, LocalDateTime startTime) {
        ValidationUtil.isValidString(name, "Name");
        ValidationUtil.isValidLocalDateTime(startTime);
        this.name = name;
        this.startTime = startTime;
    }

    public void launch() {
        try {
            logger.info("Rocket {} is launching at {}.", name, Instant.now());
            Thread.sleep(ROCKET_START_LATENCY);
            logger.info("Rocket {} successfully launched at {}.", name, Instant.now());
        } catch (InterruptedException e) {
            logger.error("Rocket {}. Launch was interrupted at {}.", name, Instant.now());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
