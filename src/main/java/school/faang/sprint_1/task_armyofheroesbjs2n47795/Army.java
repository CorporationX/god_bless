package school.faang.sprint_1.task_armyofheroesbjs2n47795;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class Army {
    private final List<Warrior> warriors = new ArrayList<>();

    public int calculateTotalPower() {

        List<PowerCalculator<Warrior>> powerCalculators = new ArrayList<>();
        Map<String, List<Warrior>> warriorMap = warriors.stream()
                .collect(Collectors.groupingBy(warrior -> warrior.getClass().getSimpleName()));

        for (String className : warriorMap.keySet()) {
            switch (className) {
              case "Archer" -> powerCalculators.add(new PowerCalculator<>(warriorMap.get("Archer")));
              case "Mage" -> powerCalculators.add(new PowerCalculator<>(warriorMap.get("Mage")));
              case "Swordsman" -> powerCalculators.add(new PowerCalculator<>(warriorMap.get("Swordsman")));
              default -> log.error("warrior map has a key(warrior class name) "
                      + "that is not processed for its own thread. Thus not calculated in calculateTotalPower()");
            }
        }

        List<Thread> threadList = new ArrayList<>();
        for (PowerCalculator<Warrior> powerCalculator : powerCalculators) {
            Thread thread = new Thread(powerCalculator);
            threadList.add(thread);
            thread.start();
        }

        try {
            for (Thread thread : threadList) {
                thread.join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int totalPower = 0;
        for (PowerCalculator<Warrior> powerCalculator : powerCalculators) {
            totalPower += powerCalculator.getSum();
        }
        return totalPower;
    }

    public void addUnit(Warrior warrior) {
        warriors.add(warrior);
    }
}
