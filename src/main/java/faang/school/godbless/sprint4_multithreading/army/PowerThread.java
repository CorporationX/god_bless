package faang.school.godbless.sprint4_multithreading.army;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PowerThread extends Thread{
    private Unit unit;
    private int unitPower;

    public void CalculatePower(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        unitPower = unit.getPower();
    }
}
