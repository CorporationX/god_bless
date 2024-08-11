package faang.school.godbless.task.hashmap.might.and.magic.hero;

import faang.school.godbless.task.hashmap.might.and.magic.creature.Creature;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class Battlefield {
    private static final double MINIMAL_DAMAGE = 1;

    private final Random random;

    public Hero battle(Hero heroA, Hero heroB) {
        List<Creature> armyOfHeroA = heroA.getArmy();
        List<Creature> armyOfHeroB = heroB.getArmy();

        showHeroAndArmy(heroA);
        showHeroAndArmy(heroB);

        // Battle while have at least one creature:
        while (!armyOfHeroA.isEmpty() && !armyOfHeroB.isEmpty()) {

            // Get random creature from army:
            Creature attackerA = getRandomCreature(armyOfHeroA);
            Creature attackerB = getRandomCreature(armyOfHeroB);

            // Damage calculate:
            double damageOfA = calculateDamage(heroA, attackerA, attackerB);
            double damageOfB = calculateDamage(heroB, attackerB, attackerA);

            // One to one fight:
            oneToOneFight(attackerA, attackerB, damageOfA, damageOfB);

            // Remove lose creature from army:
            removeLoseCreatures(attackerA, armyOfHeroA);
            removeLoseCreatures(attackerB, armyOfHeroB);
        }
        return armyOfHeroA.isEmpty() ? heroB : heroA;
    }

    public Creature getRandomCreature(List<Creature> army) {
        int size = army.size() - 1;
        int randomNumber = 0;
        if (size > 0) {
            randomNumber = random.nextInt(size);
        }
        return army.get(randomNumber);
    }

    public double calculateDamage(Hero attackerHero, Creature attacker, Creature defender) {
        double damageMultiplier = (double) attackerHero.getLevel() / 5;
        double damageLowered = (defender.getDefence() / 2) + (defender.getMovement() / 2);
        double attackerDamage = attacker.getDamage();
        attackerDamage -= damageLowered + damageMultiplier;
        attacker.setDamage(attackerDamage);
        return Math.max(attackerDamage, MINIMAL_DAMAGE);
    }

    public void oneToOneFight(Creature attackerA, Creature attackerB,
                              double damageOfA, double damageOfB) {
        System.out.println("\n%s VS %s".formatted(attackerA.getName(), attackerB.getName()));
        // Fight while health more than zero:
        while (attackerA.getHealth() > 0 && attackerB.getHealth() > 0) {
            showHealthAndDamage(attackerA);
            showHealthAndDamage(attackerB);

            if (random.nextBoolean()) {
                showAttack(attackerA, attackerB);
                applyDamage(attackerB, damageOfA);
            } else {
                showAttack(attackerB, attackerA);
                applyDamage(attackerA, damageOfB);
            }
        }
        showWinner(attackerA, attackerB);
    }

    public void applyDamage(Creature creature, double damage) {
        creature.setHealth(creature.getHealth() - damage);
    }

    public void removeLoseCreatures(Creature creature, List<Creature> army) {
        creature.reloadDamage();
        if (creature.getHealth() <= 0) {
            creature.setQuantity(creature.getQuantity() - 1);
            // health is updated if less than zero
            creature.reloadHealth();
        }
        if (creature.getQuantity() <= 0) {
            army.remove(creature);
        }
    }

    public void showHeroAndArmy(Hero hero) {
        System.out.println("Армия героя %s:".formatted(hero.getName()));
        hero.getArmy().forEach(creature -> {
            System.out.println(creature);
        });
    }

    public void showHealthAndDamage(Creature creature) {
        System.out.println("%s здоровье: %s, урон: %s"
                .formatted(creature.getName(), creature.getHealth(), creature.getDamage()));
    }

    public void showAttack(Creature attacker, Creature defender) {
        System.out.println("%s атакует %s с уроном: %s"
                .formatted(attacker.getName(), defender.getName(), attacker.getDamage()));
    }

    public void showWinner(Creature attackerA, Creature attackerB) {
        Creature winner;
        if (attackerA.getHealth() > 0) {
            winner = attackerA;
        } else {
            winner = attackerB;
        }
        System.out.println("%s выиграл схватку!".formatted(winner.getName()));
    }
}
