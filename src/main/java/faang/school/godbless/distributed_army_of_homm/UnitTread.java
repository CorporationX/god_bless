package faang.school.godbless.distributed_army_of_homm;

import lombok.AllArgsConstructor;
import lombok.Getter;
public class UnitTread extends Thread {
    private Unit unit;
    @Getter
    private int unitPower;

    public UnitTread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        unitPower = unit.getPower();
    }
}
