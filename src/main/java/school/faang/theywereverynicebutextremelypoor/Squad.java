package school.faang.theywereverynicebutextremelypoor;

import java.util.ArrayList;
import java.util.List;

public class Squad {

    private final String name;
    private List<Unit> units = new ArrayList<>();

    public Squad(String name, List<Unit> units) {
        this.name = name;
        this.units = units;
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateSquadPower() {
        return units.stream().mapToInt(Unit::getPower).sum();
    }
}
