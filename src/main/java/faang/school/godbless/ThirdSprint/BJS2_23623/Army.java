package faang.school.godbless.ThirdSprint.BJS2_23623;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {

    private AtomicInteger totalPower = new AtomicInteger(0);
    private Map<String, List<Unit>> unitTypesMap = new HashMap<>();

    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(25)); // считаем в потоке 1
        army.addUnit(new Swordsman(40)); // считаем в потоке 2
        army.addUnit(new Mage(50)); // считаем в потоке 3
        army.addUnit(new Mage(20)); // считаем в потоке 4

        System.out.println(army.calculateTotalPower());
    }

    public void addUnit(Unit unit){
        String unitTypeName = unit.getClass().getName();
        unitTypesMap.computeIfAbsent(unitTypeName, u -> new ArrayList<>()).add(unit);
    }

    public int calculateTotalPower() {
        List<Thread> threadList = unitTypesMap.entrySet()
                .stream()
                .map(e -> new Thread(() -> {
                    System.out.println(Thread.currentThread().getName());
                    unitTypesMap.get(e.getKey())
                            .stream()
                            .forEach(u -> totalPower.addAndGet(u.getPower()));
                }))
                .toList();

        threadList.stream().forEach(t -> t.start());
        threadList.stream().forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        return totalPower.get();
    }
}
