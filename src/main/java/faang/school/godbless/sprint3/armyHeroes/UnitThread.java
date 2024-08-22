package faang.school.godbless.sprint3.armyHeroes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UnitThread extends Thread {
    private final List<Unit> unitsList;
    @Getter
    private int power;

    @Override
    public void run() {
        power = unitsList.stream()
                .mapToInt(Unit::getPower)
                .sum();
    }
}
