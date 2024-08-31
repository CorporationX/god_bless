package faang.school.godbless.multithreading.parallelism.hmm;

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
        System.out.println("Unit " + unit.getClass().getSimpleName() + " has a power of " + power);
    }

}
