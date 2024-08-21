package BJS2_23424_HoMM_Multithreading;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class Army {
    private static final List<Unit> units = new ArrayList<>();
    private static final Map<String, Integer> squadsPower = new HashMap<>();

    public static void main(String[] args) {
        addUnit(new Archer("Archer", 20));
        addUnit(new Swordsman("Swordsman", 30));
        addUnit(new Mage("Mage", 60));
        addUnit(new Mage("Mage", 70));
    }

    public static int calculateTotalPower(List<Unit> units) {
        int sumPower = 0;
        for (Unit unit : units) {
            sumPower += unit.getPower();
        }
        return sumPower;
    }

    public static void addUnit(Unit unit) {
        try {
            Thread thread = new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                System.out.println("Added new unit type: " + unit.getUnitSquadName() +
                        " has " + unit.getPower() + " power");
                squadsPower.compute(unit.getUnitSquadName(), (k, v) ->
                        (v == null) ? unit.getPower() : v + unit.getPower());
                System.out.println(unit.getUnitSquadName() + " has now " +
                        squadsPower.get(unit.getUnitSquadName()) + " power");
                units.add(unit);
                System.out.println("And total power for Army is: " + calculateTotalPower(units));
            });
            thread.start();
            thread.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
