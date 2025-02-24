package school.faang.heroes_of_might_and_magic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Squad {

    Map<Integer, Mage> army = new HashMap<>();

    public int calculateSquadPower() {
        int squadPower = 0;
        for (Mage mage : army.values()) {
            squadPower += mage.getPower();
        }
        return squadPower;
    }

}
