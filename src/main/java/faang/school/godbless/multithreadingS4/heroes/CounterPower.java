package faang.school.godbless.multithreadingS4.heroes;

import lombok.Getter;

import java.util.Random;

@Getter
public class CounterPower extends Thread {
    private int powerUnit;
    private final Unit unit;

    public CounterPower(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        int sleepTime = new Random().nextInt(50) * 500;
        powerUnit = unit.getPower() * unit.getCount();
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getPowerUnit() {
        return powerUnit;
    }
}
