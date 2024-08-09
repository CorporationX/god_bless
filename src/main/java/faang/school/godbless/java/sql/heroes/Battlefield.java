package faang.school.godbless.java.sql.heroes;

import java.util.Random;

public class Battlefield {

    private Hero heroOne;
    private Hero heroTwo;

    public Battlefield(Hero heroOne, Hero heroTwo) {
        this.heroOne = heroOne;
        this.heroTwo = heroTwo;
    }

    public Hero battle() {
        Random random = new Random();
        while (heroOne.hasArmy() && heroTwo.hasArmy()) {
            Creature creatureOne = heroOne.getRandomCreature();
            Creature creatureTwo = heroTwo.getRandomCreature();

            // Hero one attacks hero two's creature
            int damageToTwo = creatureOne.getDamage();

            System.out.printf("%s: %s attacks %s (health: %d) for %d damage.%n",
                    heroOne.getName(), creatureOne.name, creatureTwo.name, creatureTwo.health, damageToTwo);
            creatureTwo.health -= damageToTwo;

            if (creatureTwo.health <= 0) {
                heroTwo.removeCreature(creatureTwo, 0);
                System.out.printf("%s's %s is defeated!%n", heroTwo.getName(), creatureTwo.name);
            } else {
                creatureTwo.recalculateQuantityFromHealth();
                heroTwo.updateCreature(creatureTwo);
            }

            // Check if hero two has any creatures left
            if (!heroTwo.hasArmy()) {
                return heroOne;
            }

            // Hero two attacks hero one's creature
            int damageToOne = creatureTwo.getDamage();
            System.out.printf("%s: %s attacks %s (health: %d) for %d damage.%n%n",
                    heroTwo.getName(), creatureTwo.name, creatureOne.name, creatureOne.health, damageToOne);
            creatureOne.health -= damageToOne;


            if (creatureOne.health <= 0) {
                heroOne.removeCreature(creatureOne, 0);
                System.out.printf("%s's %s is defeated!%n",heroOne.getName(), creatureOne.name);
            } else {
                creatureOne.recalculateQuantityFromHealth();
                heroOne.updateCreature(creatureOne);
            }

            // Check if hero one has any creatures left
            if (!heroOne.hasArmy()) {
                return heroTwo;
            }
        }

        return heroOne.hasArmy() ? heroTwo : heroOne;
    }
}
