package faang.school.godbless.DistributedArmyOfHeroesOfSwordAndMagic;

import faang.school.godbless.DistributedArmyOfHeroesOfSwordAndMagic.Heroes.Hero;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class HeroesSquad {
    private final List<Hero> squad = new ArrayList<>();

    public void addHero(Hero hero) {
        squad.add(hero);
    }

    public int getSquadPower() {
        return squad.stream()
                .mapToInt(Hero::getPower)
                .sum();
    }
}
