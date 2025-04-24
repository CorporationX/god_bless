package faang;

import faang.model.Hero;
import lombok.Getter;

import java.util.List;

public class Squad {
    @Getter
    private final String name;
    private final List<Hero> heroes;

    public Squad(String name, List<Hero> heroes) {
        this.name = name;
        this.heroes = heroes;
    }

    public int calculateSquadPower() {
        return heroes.stream()
                .mapToInt(Hero::getPower)
                .sum();
    }
}
