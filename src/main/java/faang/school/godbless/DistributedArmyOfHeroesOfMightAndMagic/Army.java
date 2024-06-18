package faang.school.godbless.DistributedArmyOfHeroesOfMightAndMagic;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

@Getter
public class Army {
    private final Map<String, List<Units>> allUnits = new HashMap<>();
    private final Map<String, Integer> powerOfEachType = new HashMap<>();

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        Set<String> types = allUnits.keySet();
        ExecutorService threadPool = Executors.newFixedThreadPool(types.size());

        for (String type : types) {
            powerOfEachType.put(type, 0);
            threadPool.submit(new calculatePowerOfType(type));
        }

        try {
            threadPool.awaitTermination(10, SECONDS);
        } catch(InterruptedException e) {
            throw new InterruptedException();
        }

        for (String type : powerOfEachType.keySet()) {
            totalPower += powerOfEachType.get(type);
        }

        threadPool.shutdown();
        return totalPower;
    }

    public void addUnit(Units unit) {
        if (!allUnits.containsKey(unit.getType())) {
            List<Units> list = new ArrayList<>();
            list.add(unit);
            allUnits.put(unit.getType(), list);
        } else {
            allUnits.get(unit.getType()).add(unit);
        }
    }

    private class calculatePowerOfType implements Runnable {
        private String type;

        @Override
        public void run() {
            System.out.println("Start counting Power of " + type);
            for (Units unit : allUnits.get(type)) {
                System.out.println(type + " " + powerOfEachType.get(type));
                powerOfEachType.put(type, powerOfEachType.get(type) + unit.getPower());
                System.out.println(type + " " + powerOfEachType.get(type));
            }
            System.out.println("End counting Power of " + type);
        }

        public calculatePowerOfType(String type) {
            this.type = type;
        }
    }

    /*
    private final Map<String, List<Units>> allUnits = new HashMap<>();
    private final Map<String, Integer> powerOfEachType = new HashMap<>();

    public int calculateTotalPower() {
        int totalPower = 0;
        Set<String> types = allUnits.keySet();
        ExecutorService threadPool = Executors.newFixedThreadPool(types.size());

        for (String type : types) {
            powerOfEachType.put(type, 0);
            threadPool.submit(new calculatePowerOfType(type));
        }

        threadPool.shutdown();

        for (String type : powerOfEachType.keySet()) {
            totalPower += powerOfEachType.get(type);
        }
        return totalPower;
    }

    public void addUnit(Units unit) {
        if (!allUnits.containsKey(unit.getType())) {
            List<Units> list = new ArrayList<>();
            list.add(unit);
            allUnits.put(unit.getType(), list);
        } else {
            allUnits.get(unit.getType()).add(unit);
        }
    }

    private class calculatePowerOfType implements Runnable {
        private String type;

        @Override
        public void run() {
            System.out.println("Start counting Power of " + type);
            for (Units unit : allUnits.get(type)) {
                powerOfEachType.compute(type, (k, i) -> i + unit.getPower());
            }
            System.out.println("End counting Power of " + type);
        }

        public calculatePowerOfType(String type) {
            this.type = type;
        }
    }*/
}
