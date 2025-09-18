package school.faang.bjs2_91247.character_groups;

import school.faang.bjs2_91247.character.Unit;
import java.util.ArrayList;
import java.util.List;

public class Squad<T extends Unit> {
    private final List<Unit> units;

    public Squad(List<T> squad) {
        if (squad.isEmpty()) {
            throw new IllegalArgumentException("Отряд должен содержать юнитов!");
        }
        units = new ArrayList<>(squad);
    }

    public List<Unit> getCharacterSquad() {
        return new ArrayList<>(units);
    }

    public int calculateSquadPower() {
        return units.stream()
                .mapToInt(Unit::getPower)
                .sum();
    }
}