package faang.school.godbless.bjs223788;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PowerCalculatorThread extends Thread {

    private final Unit unit;
    private int totalPower;

    @Override
    public void run() {
        this.totalPower = this.unit.getPower();
    }
}