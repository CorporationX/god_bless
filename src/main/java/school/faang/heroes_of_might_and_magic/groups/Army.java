package school.faang.heroes_of_might_and_magic.groups;

import lombok.Getter;
import lombok.Setter;
import school.faang.heroes_of_might_and_magic.main.Counter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Army {

    private Map<Integer, Squad> army = new HashMap<>();
    private int id = 1;
    private int armyPower;

    public int calculateTotalPower() throws InterruptedException {
        for (Integer key : army.keySet()) {
            Counter counter = new Counter(key, this);
            counter.start();
            counter.join();
        }
        return armyPower;
    }

    public void addSquad(Squad squad) {
        army.put(id, squad);
        id++;
    }
}
