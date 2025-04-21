package distributedheroesarmy;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateSquadPower() {
        return this.units.stream()
                .mapToInt(Unit::getPower)
                .sum();
    }
}
