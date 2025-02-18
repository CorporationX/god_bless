package school.faang.armyheroes;

import java.util.ArrayList;
import java.util.List;

public class Squad<T extends Heroes> {
    private final List<T> heroes;

    public Squad() {
        heroes = new ArrayList<>();
    }

    public void addHeroes(T heroes) {
        this.heroes.add(heroes);
    }

    public int calculateSquadPower() {
        return heroes.stream()
                .mapToInt(Heroes::getPower)
                .sum();
    }
}
