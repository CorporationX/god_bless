package school.faang.bjs248527;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Swordsman extends Unit {
    public Swordsman(int power) {
        super(power);
        if (power < 0) {
            log.error("Attempted to create Swordsman with negative power: {}", power);
            throw new IllegalArgumentException("Power cannot be negative: " + power);
        }
        log.info("Creating Swordsman with power = {}", power);
    }

    @Override
    public String toString() {
        return "Swordsman{" + "power=" + power + '}';
    }
}