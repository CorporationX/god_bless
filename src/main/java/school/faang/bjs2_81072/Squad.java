package school.faang.bjs2_81072;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

public class Squad {
    private List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateSquadPower() {
        return units.stream()
                .mapToInt(Unit::getPower).sum();
    }
}
