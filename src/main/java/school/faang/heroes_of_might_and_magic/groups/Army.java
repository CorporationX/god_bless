package school.faang.heroes_of_might_and_magic.groups;

import lombok.Getter;
import school.faang.heroes_of_might_and_magic.main.Counter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Army {

    public static Map<Integer, Squad> army = new HashMap<>();
    private int id = 1;

    public int calculateTotalPower() {
        int totalPower = 0;
        for (Integer key : army.keySet()) {
            Counter counter = new Counter(key);
            counter.start();
            totalPower += counter.getArmyPower();
        }
        return totalPower;
    }

    public void addSquad(Squad squad) {
        army.put(id, squad);
        id++;
    }
}
