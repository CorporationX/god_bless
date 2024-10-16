package school.faang.geroes_thord_and_magic_BJS2_35856;

import lombok.Getter;

@Getter
public class PowerCalculator implements Runnable{
    private Unit unit;
    private int power;

    public PowerCalculator(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
       this.power = unit.getPower();
    }
}
