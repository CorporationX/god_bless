package faang.school.godbless.BJS2_5752;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PowerCalculationThread extends Thread {
    private final Creature creature;
    private int power;

    @Override
    public void run() {
        power = creature.getPower();
        System.out.printf("Added %s power\n", power);
    }
}
