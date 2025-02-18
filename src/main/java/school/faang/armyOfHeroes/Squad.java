package school.faang.armyOfHeroes;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Squad {
    private final String name;
    private final List<Hero> heroes = new ArrayList<>();
    private int totalPower = 0;

    public Squad(String name) {
        this.name = name;
    }

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    public void calculateSquadPower() {
        totalPower = heroes.stream().mapToInt(Hero::getPower).sum();
    }
}
