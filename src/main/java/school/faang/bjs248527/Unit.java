package school.faang.bjs248527;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Unit {
    protected int power;

    public Unit(int power) {
        if (power < 0) {
            log.error("Attempted to create Unit with negative power: {}. Power must be a non-negative integer.", power);
            throw new IllegalArgumentException("Power cannot be negative: "
                    + power + ". Please provide a non-negative integer value.");
        }
        this.power = power;
        log.info("Successfully created Unit with power = {}", power);
    }

    @Override
    public String toString() {
        return "Unit{" + "power=" + power + '}';
    }
}