package faang.school.godbless.ThirdSprint.BJS2_23623;

import java.util.HashMap;
import java.util.Map;

public class Army {
    Map<String, Unit> unitTypesMap = new HashMap<>();
    Map<String, CalculateTasks> tasksMap = new HashMap<>();
    Map<String, Thread> threadMap = new HashMap<>();

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
        unitTypesMap.putIfAbsent(unitTypeName, unit);
        CalculateTasks tasksByUnitType = tasksMap.computeIfAbsent(unitTypeName, u -> new CalculateTasks());
        tasksByUnitType.getList().add(unit);
        threadMap.computeIfAbsent(unitTypeName, u -> new Thread(tasksByUnitType));
    }

    public int calculateTotalPower(){
        threadMap.keySet().stream()
                .forEach(t -> threadMap.get(t).start());
        threadMap.keySet().stream()
                .forEach(t -> {
            try {
                threadMap.get(t).join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        return unitTypesMap.entrySet().stream()
                .map( u -> u.getValue())
                .mapToInt(u -> u.getTotalPower())
                .sum();
    }
}
