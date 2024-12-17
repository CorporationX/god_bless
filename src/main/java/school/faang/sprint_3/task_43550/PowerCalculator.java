package school.faang.sprint_3.task_43550;

import lombok.Data;

@Data
public class PowerCalculator implements Runnable {
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
