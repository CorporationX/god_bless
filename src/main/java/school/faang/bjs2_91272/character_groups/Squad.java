package school.faang.bjs2_91272.character_groups;

import school.faang.bjs2_91272.character.Unit;

import java.util.ArrayList;
import java.util.List;

public class Squad<T extends Unit> {
    private final List<T> squadUnits;

    public Squad(List<T> units) {
        squadUnits = new ArrayList<>(units);
    }

    public List<Unit> getSquadUnits() {
        return new ArrayList<>(squadUnits);
    }

    public int calculateSquadPower() {
        return squadUnits.stream()
                .mapToInt(Unit::getPower)
                .sum();
    }
}
