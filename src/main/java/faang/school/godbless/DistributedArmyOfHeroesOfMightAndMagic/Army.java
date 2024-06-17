package faang.school.godbless.DistributedArmyOfHeroesOfMightAndMagic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Army {
    private final Map<String, List<Units>> allUnits = new HashMap<>();

    public int calculateTotalPower() {
        Set<String> types = allUnits.keySet();
        ExecutorService threadPool = Executors.newFixedThreadPool(types.size());

        for (String type : types) {
            threadPool.submit(calculatePowerOfType(type));
        }
    }

    public Runnable calculatePowerOfType(String type) {
        int result = 0;
        for (Units unit : allUnits.get(type)) {
            result += unit.getPower();
        }
        return null;
    }

    public void addUnit(Units unit) {
        if (!allUnits.containsKey("Archer")) {
            List<Units> list = new ArrayList<>();
            list.add(unit);
            allUnits.put("Archer", list);
        } else {
            allUnits.get(unit.getType()).add(unit);
        }
    }
}
