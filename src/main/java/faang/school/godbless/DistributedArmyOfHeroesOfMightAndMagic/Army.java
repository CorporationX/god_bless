package faang.school.godbless.DistributedArmyOfHeroesOfMightAndMagic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Army {
    private final Map<String, List<Units>> units = new HashMap<>();

    public int calculateTotalPower() {
        Set<String> types = units.keySet();
        ExecutorService threadPool = Executors.newFixedThreadPool(types.size());

        for (String type : types) {

        }
    }

    public void addUnit(Units unit) {
        if (!units.containsKey("Archer")) {
            List<Units> list = new ArrayList<>();
            list.add(unit);
            units.put("Archer", list);
        } else {
            units.get(unit.getType()).add(unit);
        }
    }
}
