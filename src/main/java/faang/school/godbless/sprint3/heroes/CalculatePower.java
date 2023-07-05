package faang.school.godbless.sprint3.heroes;

import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class CalculatePower extends Thread {

    private Unit unit;
    private int unitPower;

    public CalculatePower(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        unitPower = unit.getPower();
    }
}
