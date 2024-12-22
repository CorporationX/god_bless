package school.faang.bjs248527;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Mage extends Unit {
    public Mage(int power) {
        super(power);
        if (power < 0) {
            log.error("Attempted to create Mage with negative power: {}", power);
            throw new IllegalArgumentException("Power cannot be negative: " + power);
        }
        log.info("Creating Mage with power = {}", power);
    }

    @Override
    public String toString() {
        return "Mage{" + "power=" + power + '}';
    }

}