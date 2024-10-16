package school.faang.army;

import lombok.Getter;

import java.util.Objects;

@Getter
public class PowerCalculator implements Runnable {

    private final Unit unit;

    private int result;

    public PowerCalculator(Unit unit) {
        Objects.requireNonNull(unit, "Unit cannot be null");
        this.unit = unit;
    }

    @Override
    public void run() {
        result = unit.getPower();
    }
}
