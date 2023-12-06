package faang.school.godbless.army.heroes.might.magic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UnitThread extends Thread {
    private Unit unit;
    private int unitPower;

    public UnitThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        unitPower = unit.getPower();
    }
}
