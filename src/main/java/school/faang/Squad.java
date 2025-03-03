package school.faang;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private final List<Unit> units = new ArrayList<>();

    public void addUnit(@NonNull Unit unit) {
        units.add(unit);
    }

    public int calculateSquadPower() {
        return units.stream()
                .mapToInt(Unit::getPower)
                .sum();
    }
}
