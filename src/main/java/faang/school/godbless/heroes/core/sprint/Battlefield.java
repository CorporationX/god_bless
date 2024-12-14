package faang.school.godbless.heroes.core.sprint;

import faang.school.godbless.heroes.core.sprint.creature.Creature;
import faang.school.godbless.heroes.core.sprint.creature.Griffin;
import faang.school.godbless.heroes.core.sprint.creature.Pikeman;
import faang.school.godbless.heroes.core.sprint.creature.Swordman;
import faang.school.godbless.heroes.core.sprint.creature.Angel;

import java.util.List;
import java.util.Map;

public class Battlefield {
    public static void main(String[] args) {
        Hero sandro = new Hero("Sandro", "Magic", 1000, 3);
        sandro.addCreature(new Angel(), 5);
        sandro.addCreature(new Griffin(), 21);

        Hero jeddit = new Hero("Jeddit", "Necromant", 1200, 4);
        jeddit.addCreature(new Pikeman(), 20);
        jeddit.addCreature(new Swordman(), 35);
        jeddit.addCreature(new Griffin(), 15);

        battle(sandro, jeddit);
    }

    private static void battle(Hero attackingHero, Hero attackedHero) {

        System.out.printf("%s has an army: %s\n", attackingHero.getName(), attackingHero.getArmy());
        System.out.printf("%s has an army: %s\n\n", attackedHero.getName(), attackedHero.getArmy());

        while (attackingHero.hasArmy() && attackedHero.hasArmy()) {
            attack(attackingHero, attackedHero);
            if (!attackedHero.hasArmy()) {
                System.out.printf("%s won the battle!\n", attackingHero.getName());
                break;
            }

            attack(attackedHero, attackingHero);
            if (attackingHero.getCreatures().isEmpty()) {
                System.out.printf("%s won the battle!\n", attackedHero.getName());
                break;
            }
        }
    }

    private static void attack(Hero attackingHero, Hero attackedHero) {
        Map<String, Creature> attackingCreatures = attackingHero.getCreatures();
        Map<String, Creature> attackedCreatures = attackedHero.getCreatures();

        for (String creatureName : attackingCreatures.keySet()) {
            Creature attackingCreature = attackingCreatures.get(creatureName);
            Creature attackedCreature = getRandomCreature(attackedCreatures);
            System.out.printf("%s's %ss attacks %s's %ss\n",
                    attackingHero.getName(), attackingCreature.getName(),
                    attackedHero.getName(), attackedCreature.getName());

            attackingCreature.attack(attackedCreature);

            if (attackedCreature.getQuantity() == 0) {
                System.out.printf("Attacked %ss in %s's army terminated\n", attackedCreature.getName(), attackedHero.getName());
                attackedHero.removeCreature(attackedCreature);
                attackedCreatures.remove(attackedCreature.getName());

                if (attackedCreatures.isEmpty()) {
                    break;
                }
            } else {
                attackedHero.updateCreature(attackedCreature);
                attackedCreatures.put(attackedCreature.getName(), attackedCreature);
                System.out.printf("%d %ss left in %s's army\n", attackedCreature.getQuantity(),
                        attackedCreature.getName(), attackedHero.getName());
            }
        }
    }

    private static Creature getRandomCreature(Map<String, Creature> attackedCreatures) {
        int randomIndex = getRandomIndex(attackedCreatures.size() - 1);
        return attackedCreatures
                .get(List.copyOf(attackedCreatures.keySet())
                        .get(randomIndex));
    }

    private static int getRandomIndex(int size) {
        return (int) ((Math.random() * (size)));
    }
}
