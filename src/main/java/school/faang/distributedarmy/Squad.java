package school.faang.distributedarmy;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private final List<Hero> heroes = new ArrayList<>();

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    public int calculateSquadPower() {
        return heroes.stream().mapToInt(Hero::getPower).sum();
    }
}