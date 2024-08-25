package faang.school.godbless.BJS2_23421;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class UnitPowerCalculator extends Thread {
    private int power;
    private final List<Unit> UNIT;

    @Override
    public void run() {
        power = UNIT.stream()
                .mapToInt(Unit::getPOWER)
                .sum();
    }
}