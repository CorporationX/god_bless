package faang.school.godbless.HoMMarmy;

import faang.school.godbless.HoMMarmy.units.Unit;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CalculatePowerThread extends Thread {
    private final Unit unit;
    private final int count;
    private int totalPower;

    @Override
    public void run() {
        totalPower = unit.getPower() * count;
    }

    public int getTotalPower() {
        return totalPower;
    }
}
