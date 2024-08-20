package faang.school.godbless.sprint3.armyHeroes;

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
    }
}
