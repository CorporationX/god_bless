package faang.school.godbless.BJS2_23421;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UnitPowerCalculator extends Thread {
    private int power;
    private final Unit UNIT;

    @Override
    public void run() {
        power = UNIT.getPOWER();
    }
}