package dima.evseenko.army;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PowerCalculatorThread extends Thread {
    private final Unit unit;

    @Getter
    private int power;

    @Override
    public void run() {
        power = unit.getPower();
    }
}
