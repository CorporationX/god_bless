package faang.school.godbless.multithreadingS4.heroes;

import lombok.Getter;

@Getter
public class CounterPower extends Thread {
    private static int fullPowerArmy;
    private Unit unit;

    public CounterPower(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        int power = unit.getPower() * unit.getCount();
        increaseFullPower(power);
    }

    public static int getFullPowerArmy() {
        return fullPowerArmy;
    }

    private static synchronized void increaseFullPower(int power) {
        fullPowerArmy += power;
    }
}
