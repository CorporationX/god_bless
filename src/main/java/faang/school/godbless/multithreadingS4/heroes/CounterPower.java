package faang.school.godbless.multithreadingS4.heroes;

import lombok.Getter;

import java.util.Random;

@Getter
public class CounterPower extends Thread {
    private static int fullPowerArmy;
    private Unit unit;

    public CounterPower(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        int sleepTime = new Random().nextInt(50) * 500;
        System.out.printf("Tread started: %s%n\tSleep time for thread: %d%n",
                Thread.currentThread().getName(),
                sleepTime);

        int power = unit.getPower() * unit.getCount();

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Tread name: %s%n\tCaclulate power: %d%n",
                Thread.currentThread().getName(),
                power);

        System.out.printf("Full power before: %d%n", fullPowerArmy);

        increaseFullPower(power);

        System.out.printf("Full power after: %d%n%n", fullPowerArmy);
    }

    public static int getFullPowerArmy() {
        return fullPowerArmy;
    }

    private static synchronized void increaseFullPower(int power) {
        fullPowerArmy += power;
    }
}
