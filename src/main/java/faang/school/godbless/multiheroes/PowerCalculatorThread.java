package faang.school.godbless.multiheroes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PowerCalculatorThread extends Thread {

    private final Unit unit;
    private int power;

    @Override
    public void run() {
        power = unit.getPower();
    }
}
