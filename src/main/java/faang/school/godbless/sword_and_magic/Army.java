package faang.school.godbless.sword_and_magic;

import faang.school.godbless.sword_and_magic.units.Unit;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public class Army {
    private final List<Unit> allUnits;

    public int calculateTotalPower() {
        Map<String, List<Unit>> groupedSquads = allUnits.stream()
                .collect(Collectors.groupingBy(u -> u.getClass().getTypeName()));

        AtomicInteger totalPower = new AtomicInteger(0);
        List<UnitThread> threads = threadsByUnitType(groupedSquads, totalPower);
        threads.forEach(t -> {
            try {
                t.join();
            } catch(InterruptedException e) {
                System.out.printf("Thread with name '%s' has been interruped!", t.getName());
            }
        });

        return totalPower.intValue();
    }

    private List<UnitThread> threadsByUnitType(Map<String, List<Unit>> groupedByUnitType, AtomicInteger totalPower) {
        return groupedByUnitType.keySet().stream()
                .map(k -> new UnitThread(groupedByUnitType.get(k), totalPower))
                .peek(UnitThread::start)
                .toList();
    }
}
