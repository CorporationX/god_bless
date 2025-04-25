package school.faang.bjs2_72251.model;

import school.faang.bjs2_72251.model.unit.BaseUnit;

import java.util.List;

public record Squad(String name, List<BaseUnit> units) {
    public int calculateSquadPower() {
        return units.stream()
                .mapToInt(BaseUnit::getPower)
                .sum();
    }
}