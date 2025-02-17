package school.faang.BJS2_61080.army;

import school.faang.BJS2_61080.units.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Squad {
    private final List<Fighter> fighters;

    public Squad(FighterType type, List<Integer> powers) {
        List<Fighter> tempFighters = new ArrayList<>();
        switch (type) {
            case MAGE -> {
                powers.forEach(power -> {
                    tempFighters.add(new Mage(power));
                });
                fighters = tempFighters;
            }
            case ARCHER -> {
                powers.forEach(power -> {
                    tempFighters.add(new Archer(power));
                });
                fighters = tempFighters;
            }

            default -> {
                powers.forEach(power -> {
                    tempFighters.add(new SwordsMan(power));
                });
                fighters = tempFighters;
            }
        }
    }

    public int calculateSquadPower() {
        Objects.requireNonNull(fighters, "List<Fighter> can't be null");

        return fighters.stream()
                .mapToInt(Fighter::getPower)
                .sum();
    }
}
