package faang.school.godbless.BJS2_23412;

import lombok.Getter;

public class UnitThread extends Thread {

    private final Unit unit;
    @Getter
    private int power;

    public UnitThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        power = unit.getPower();
        System.out.println("Thread started");
    }
}
