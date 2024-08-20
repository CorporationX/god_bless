package faang.school.godbless.BJS2_23550;

import java.util.LinkedList;
import java.util.List;

public class Army {
    private List<Unit> units = new LinkedList<>();

    public void add(Unit unit) {
        units.add(unit);
    }

    public double calculateTotalPower() {
        return units.parallelStream().mapToDouble(Unit::getPower).sum();
    }
}