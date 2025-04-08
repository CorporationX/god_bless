package school.faang.bjs248527;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class PowerCalculator implements Runnable {

    private final Unit unite;
    private int power;

    public PowerCalculator(Unit unite) {
        if (unite == null) {
            log.error("Unit cannot be null. Please provide a valid Unit instance to initialize the PowerCalculator.");
            throw new IllegalArgumentException("Unit cannot be null. A valid Unit instance is required.");
        }
        this.unite = unite;
        log.info("PowerCalculator created for unit with power = {}", unite.getPower());
    }

    @Override
    public void run() {
        this.power = unite.getPower();
        log.info("PowerCalculator is running with power = {}", this.power);
    }
}
