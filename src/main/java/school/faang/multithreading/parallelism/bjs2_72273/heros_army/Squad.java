package school.faang.multithreading.parallelism.bjs2_72273.heros_army;

import school.faang.multithreading.parallelism.bjs2_72273.heros_army.fighters.Fighter;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private final List<Fighter> fighters = new ArrayList<>();

    public void addFighter(Fighter fighter) {
        fighters.add(fighter);
    }

    public int calculateSquadPower() {
        return fighters.stream()
                .mapToInt(Fighter::getPower)
                .sum();
    }

}
