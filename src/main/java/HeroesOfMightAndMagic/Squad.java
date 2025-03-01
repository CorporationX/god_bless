package HeroesOfMightAndMagic;

import java.util.List;

public class Squad {

    private final List<Unit> units;

    public Squad(List<Unit> units) {
        this.units = units;
    }

    public int calculateSquadPower() {
        return units.stream()
                .mapToInt(Unit::getPower).sum();

    }
}
