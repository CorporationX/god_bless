package a_distributed_army_of_heroes_of_might_and_magic;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Warrior> units = new ArrayList<>();

    public void addUnit(Warrior unit) {
        new Thread(() -> units.add(unit)).start();
        System.out.println("Unit added: " + unit.getClass().getName());
    }

    public int calculateTotalPower() {
        return units.stream().map(Warrior::getPower).reduce(0, Integer::sum);
    }
}
