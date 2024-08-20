package faang.school.godbless.BJS223397;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor
public class Army {
    private List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {
        Map<Class<? extends Unit>, List<Unit>> groupedUnits = units.stream()
                .collect(Collectors.groupingBy(Unit::getClass));

        int totalPower = groupedUnits.entrySet().stream()
                .mapToInt(entry -> {
                    List<UnitThread> unitThreads = entry.getValue().stream()
                            .map(UnitThread::new)
                            .peek(UnitThread::start)
                            .toList();

                    try {
                        int powerSum = getPowerSum(unitThreads);

                        System.out.println(entry.getKey().getSimpleName() + " power sum: " + powerSum);

                        return powerSum;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return 0;
                    }
                }).sum();

        return totalPower;
    }

    public int getPowerSum(List<UnitThread> unitThreads) throws InterruptedException {
        int powerSum = 0;
        for (UnitThread unitThread : unitThreads) {
            unitThread.join();
            powerSum += unitThread.getPower();
        }
        return powerSum;
    }
}
