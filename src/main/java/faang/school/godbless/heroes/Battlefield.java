package faang.school.godbless.heroes;

import faang.school.godbless.heroes.entity.creatures.Creature;
import faang.school.godbless.heroes.entity.heroes.Hero;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Battlefield {
    public static void battle(Hero hero1, Hero hero2) {
        int totalHero1Damage = hero1.getArmy()
                .stream()
                .mapToInt(Creature::getDamage)
                .sum();
        int totalHero2Damage = hero2.getArmy()
                .stream()
                .mapToInt(Creature::getDamage)
                .sum();

        System.out.println(hero1.getName() + " deal " + totalHero1Damage + " damage, "
                + hero2.getName() + " deal " + totalHero2Damage + " damage.");

        if (totalHero1Damage > totalHero2Damage) {
            System.out.println("Winner: " + hero1.getName());
        } else if (totalHero1Damage < totalHero2Damage) {
            System.out.println("Winner: " + hero2.getName());
        } else {
            System.out.println("Winner has not been revealed");
        }
        System.out.println();
    }
}
