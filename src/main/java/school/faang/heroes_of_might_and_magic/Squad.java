package school.faang.heroes_of_might_and_magic;

import java.util.List;

public record Squad(List<Unit> units) {
    public int calculateSquadPower() {
        return units.stream().mapToInt(Unit::getPower).sum();
    }
}
