package faang.school.godbless.BJS2_23412;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PowerCalculator extends Thread {

    private final Unit unit;
    @Getter
    private int power;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        power = unit.getPower();
    }
}
