package school.faang.sprint_3.heroes;

import lombok.Getter;
import school.faang.sprint_3.heroes.units.Unit;

@Getter
public class PowerCalculator extends Thread {
    private final Unit unit;
    private int power;

    public PowerCalculator(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        this.power = unit.getPower();
    }
}
