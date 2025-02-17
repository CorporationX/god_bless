package school.faang.HeroesOfMightAndMagic;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Squad {
    private final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        units.add(unit);
    }

    public int calculateSquadPower() {
        if (isEmpty()) {
            return 0; // Отряд пуст
        }
        return units.stream()
                .mapToInt(Unit::getPower)
                .sum();
    }

    private boolean isEmpty() {
        return units.isEmpty();
    }
}