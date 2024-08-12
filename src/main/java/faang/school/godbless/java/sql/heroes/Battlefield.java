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
            executeRound(roundCount);
            if (!heroTwo.hasArmy()) return heroOne;
            if (!heroOne.hasArmy()) return heroTwo;
        }
        return determineWinner();
    }

    private void executeRound(int roundCount) {
        System.out.printf("------------------ Round %d started ------------------%n", roundCount);

        Creature creatureOne = heroOne.getRandomCreature();
        Creature creatureTwo = heroTwo.getRandomCreature();

        attack(creatureOne, creatureTwo, heroOne, heroTwo);
        if (heroTwo.hasArmy()) {
            attack(creatureTwo, creatureOne, heroTwo, heroOne);
        }
    }

    private void attack(Creature attacker, Creature defender, Hero attackerHero, Hero defenderHero) {
        int damage = attackerHero.getCommonDamage(attacker);

        System.out.printf("%s: %s attacks %s (health: %d) for %d damage.%n",
                attackerHero.getName(), attacker.name, defender.name, defender.health, damage);

        defender.health -= damage;
        if (defender.health <= 0) {
            defenderHero.removeCreature(defender);
            System.out.printf("%s's %s is defeated!%n", defenderHero.getName(), defender.name);
        } else {
            defenderHero.recalculateQuantityFromHealth(defender);
            defenderHero.updateCreature(defender);
        }
    }

    private Hero determineWinner() {
        return heroOne.hasArmy() ? heroOne : heroTwo;
    }

}
