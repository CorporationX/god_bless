package heroes_of_might_and_magic;

import java.util.Map;

public class Battlefield {
    public Hero battle(Hero firstHero, Hero secondHero) {
        int hero1Power = calculateArmyPower(firstHero);
        int hero2Power = calculateArmyPower(secondHero);

        System.out.println(firstHero.getName() + " Army Power: " + hero1Power);
        System.out.println(secondHero.getName() + " Army Power: " + hero2Power);

        if (hero1Power > hero2Power) {
            System.out.println(firstHero.getName() + " wins the battle!");
            return firstHero;
        } else if (hero2Power > hero1Power) {
            System.out.println(secondHero.getName() + " wins the battle!");
            return secondHero;
        } else {
            System.out.println("It's a draw!");
            return null;
        }
    }

    private int calculateArmyPower(Hero hero) {
        int totalPower = 0;
        for (Map.Entry<Creature, Integer> entry : hero.getArmy().entrySet()) {
            Creature creature = entry.getKey();
            int quantity = entry.getValue();
            totalPower += creature.getDamage() * quantity;
        }
        return totalPower;
    }
}
