package school.faang.heroes_of_might_and_magic;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Проект: god_bless
 * Класс Squad
 * Автор: Vital
 */

@Getter
public class Squad {
    private final String name;
    private final List<Unit> units = new ArrayList<>();

    public Squad(@NonNull String name) {
        this.name = name;
    }

    public void addUnit(@NonNull Unit unit) {
        units.add(unit);
    }

    public int calculateSquadPower() {
        return units.stream().mapToInt(Unit::getPower).sum();
    }
}