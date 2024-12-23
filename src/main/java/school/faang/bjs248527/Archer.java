package school.faang.bjs248527;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Archer extends Unit {
    public Archer(int power) {
        super(power);
        if (power < 0) {
            log.error("Attempted to create Archer with negative power: {}", power);
            throw new IllegalArgumentException("Power cannot be negative: " + power);
        }
        log.info("Creating Archer with power = {}", power);
    }

    @Override
    public String toString() {
        return "Archer{" + "power=" + power + '}';
    }
}