package school.faang.heroes_of_might_and_magic.groups;

import school.faang.heroes_of_might_and_magic.main.Counter;

import java.util.HashMap;
import java.util.Map;

public class Army {

    public static Map<Integer, Squad> army = new HashMap<>();
    private int id = 1;

    public int calculateTotalPower() {
        int totalPower = 0;
        for (Integer key : army.keySet()) {
            Counter counter = new Counter(key);
            counter.run(); //вот здесь момент не очень понятен, если использую start(), то armyPower = 0,
            // объясните, пожалуйста
            totalPower += counter.getArmyPower();
        }
        return totalPower;
    }

    public void addSquad(Squad squad) {
        army.put(id, squad);
        id++;
    }
}
