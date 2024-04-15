package faang.school.godbless.HerosAndMagicArmy;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UnitThread extends Thread {
    private final Unit unit;
    private int power;

    @Override
    public void run() {
        power = unit.getPower();
    }
}
