package school.faang.homm;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Battlefield {
    private Hero hero1;
    private Hero hero2;

    public Hero battle() {
        return getTotalDamage(hero1) >= getTotalDamage(hero2) ? hero1 : hero2;
    }

    private int getTotalDamage(Hero hero) {
        return hero.getArmy()
                .stream()
                .mapToInt(Creature::getAmountOfDamage)
                .sum();
    }
}
