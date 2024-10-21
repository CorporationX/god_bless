package school.faang.BJS2_35898;

import lombok.Getter;

@Getter
public class UnitThread extends Thread {
    private int countPower;
    private final Unit unit;

    public UnitThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        countPower = unit.getPower();
    }
}
