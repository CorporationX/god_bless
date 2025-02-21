package bjs2_56245;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.OffsetDateTime;

public record RocketLaunch(String name, OffsetDateTime launchTime) {
    private static final Logger logger = LoggerFactory.getLogger(RocketLaunch.class);

    public void launch() throws InterruptedException {
        Thread.sleep(1000);
        logger.info("Ракета {} запущена", name);
    }
}
