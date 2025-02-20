package school.faang.BJS2_61080.army;

import school.faang.BJS2_61080.units.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Squad {
    private final List<Fighter> fighters;

    public Squad(Fighter fighter, int count) {
        Objects.requireNonNull(fighter, "List<Fighter> can't be null");

        this.fighters = createSquad(fighter, count);
    }

    public int calculateSquadPower() {
        Objects.requireNonNull(fighters, "List<Fighter> can't be null");

        return fighters.stream()
                .mapToInt(Fighter::getPower)
                .sum();
    }

    private List<Fighter> createSquad(Fighter fighter, int count) {
        List<Fighter> tempFighters = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tempFighters.add(fighter);
        }
        return tempFighters;
    }
}
