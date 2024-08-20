package faang.school.godbless.BJS2_23412;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UnitThread extends Thread {

    private final Unit unit;
    @Getter
    private int power;

    @Override
    public void run() {
        power = unit.getPower();
        System.out.println("Thread started");
    }
}
