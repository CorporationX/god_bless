package school.faang.heroes_of_the_magic;

import java.util.ArrayList;
import java.util.List;

public class Squad<T extends Heroes> {
    private final List<T> squadHeroes = new ArrayList<>();

    public int calculateSquadPower() {
        return squadHeroes.stream()
                .mapToInt(Heroes::getPower)
                .sum();
    }

    public void addUnit(T t) {
        squadHeroes.add(t);
    }
}
