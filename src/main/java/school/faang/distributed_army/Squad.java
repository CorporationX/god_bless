package school.faang.distributed_army;

import java.util.ArrayList;
import java.util.List;

public class Squad<T extends Hero> {
    private List<T> heroesOfOneType = new ArrayList<>();

    public Squad(T hero, int numberOfHeroes) {
        for (int i = 0; i < numberOfHeroes; i++) {
            heroesOfOneType.add(hero);
        }
    }

    public int calculateSquadPower() {
        int sumPower = 0;
        for (T hero : heroesOfOneType) {
            sumPower += hero.getPower();
        }
        return sumPower;
    }
}
