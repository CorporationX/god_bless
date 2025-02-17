package school.faang.HeroesOfMightAndMagic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Army {
    private static final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        if (squad == null) {
            throw new IllegalArgumentException("Squad cannot be null");
        }
        squads.add(squad);
    }

    public static int calculateTotalPower() {
        if (squads.isEmpty()) {
            return 0;
        }
        return squads.parallelStream()
                .filter(Objects::nonNull) // Игнорируем null-элементы в списке
                .mapToInt(Squad::calculateSquadPower)
                .sum();
    }
}