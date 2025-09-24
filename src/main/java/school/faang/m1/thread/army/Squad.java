package school.faang.m1.thread.army;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Squad {

    @Getter
    private final String name;

    @Getter
    private final List<Unit> units = new ArrayList<>();

    public Squad(String name, List<Unit> units) {
        this.name = name;
        if (units != null) {
            this.units.addAll(units);
        }
    }

    public void add(Unit unit) {
        if (unit != null) {
            units.add(unit);
        }
    }

    public int calculateSquadPower() {

        return units.stream()
                .filter(Objects::nonNull)
                .mapToInt(Unit::getPower)
                .sum();
    }

}
