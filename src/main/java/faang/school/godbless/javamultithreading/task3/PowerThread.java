package faang.school.godbless.javamultithreading.task3;

import lombok.Getter;

@Getter
public class PowerThread extends Thread {

    private final int power;

    public PowerThread(Unit unit) {
        this.power = unit.getPower();
    }
}
