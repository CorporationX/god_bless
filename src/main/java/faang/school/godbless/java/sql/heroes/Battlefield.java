package faang.school.godbless.java.sql.heroes;


public class Battlefield {

    private Hero heroOne;
    private Hero heroTwo;

    public Battlefield(Hero heroOne, Hero heroTwo) {
        this.heroOne = heroOne;
        this.heroTwo = heroTwo;
    }

    public Hero battle() {
        int roundCount = 0;
        while (heroOne.hasArmy() && heroTwo.hasArmy()) {
            roundCount++;

            System.out.printf("------------------ Round %d started ------------------%n",
                    roundCount);

            Creature creatureOne = heroOne.getRandomCreature();
            Creature creatureTwo = heroTwo.getRandomCreature();

            int creatureOneDamage = creatureOne.getDamage();

            System.out.printf("%s: %s attacks %s (health: %d) for %d damage.%n",
                    heroOne.getName(), creatureOne.name, creatureTwo.name, creatureTwo.health, creatureOneDamage);
            creatureTwo.health -= creatureOneDamage;

            if (creatureTwo.health <= 0) {
                heroTwo.removeCreature(creatureTwo);
                System.out.printf("%s's %s is defeated!%n", heroTwo.getName(), creatureTwo.name);
            } else {
                creatureTwo.recalculateQuantityFromHealth();
                heroTwo.updateCreature(creatureTwo);
            }

            if (!heroTwo.hasArmy()) {
                return heroOne;
            }

            int creatureTwoDamage = creatureTwo.getDamage();
            System.out.printf("%s: %s attacks %s (health: %d) for %d damage.%n%n",
                    heroTwo.getName(), creatureTwo.name, creatureOne.name, creatureOne.health, creatureTwoDamage);
            creatureOne.health -= creatureTwoDamage;


            if (creatureOne.health <= 0) {
                heroOne.removeCreature(creatureOne);
                System.out.printf("%s's %s is defeated!%n",heroOne.getName(), creatureOne.name);
            } else {
                creatureOne.recalculateQuantityFromHealth();
                heroOne.updateCreature(creatureOne);
            }

            if (!heroOne.hasArmy()) {
                return heroTwo;
            }
        }

        return heroOne.hasArmy() ? heroTwo : heroOne;
    }
}
