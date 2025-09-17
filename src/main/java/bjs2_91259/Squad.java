package bjs2_91259;

import java.util.*;

public class Squad {
    private final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateSquadPower() {
        return units.stream().mapToInt(Unit::getPower).sum();
    }
}
