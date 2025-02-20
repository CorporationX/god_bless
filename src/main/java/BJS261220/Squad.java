package BJS261220;

import java.util.*;

import static java.lang.Integer.sum;

public class Squad {
    private final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        if (unit == null) {
            throw new NullPointerException("unit cannot be null");
        }
        units.add(unit);
    }

    public int calculateSquadPower() {
        return units.stream().mapToInt(Unit::getPower).sum();
    }
}
