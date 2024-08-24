package faang.school.godbless.distributedarmy;

import lombok.Getter;

@Getter
public class MyThread extends Thread {
    private final Unit unit;
    private int power;

    public MyThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        power = unit.getPower();
    }
}