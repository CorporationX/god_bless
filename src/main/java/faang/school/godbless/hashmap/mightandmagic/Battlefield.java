package faang.school.godbless.hashmap.mightandmagic;

import faang.school.godbless.hashmap.mightandmagic.creatures.Creature;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.random.RandomGenerator;

public class Battlefield {

    public Hero battle(Hero heroX, Hero heroY) {
        LinkedList<Creature> armyX = heroX.getArmy();
        LinkedList<Creature> armyY = heroY.getArmy();

        sortArmiesBySpeed(armyX, armyY);

        while (true) {
            attack(armyX, armyY);
            if(armyY.isEmpty()) {
                return heroX;
            }
            attack(armyY, armyX);
            if(armyX.isEmpty()) {
                return heroY;
            }
        }
    }

    private void attack(LinkedList<Creature> attackingArmy, LinkedList<Creature> attackedArmy) {
        Creature attackingCreature = attackingArmy.pollFirst();
        Creature attackedCreature = rollAttackedCreature(attackedArmy);

        attackedCreature.takeDamage(attackingCreature.getDamage());
        attackingArmy.offerLast(attackingCreature);
        if(attackedCreature.getQuantity() <= 0) {
            attackedArmy.remove(attackedCreature);
        }
    }

    private Creature rollAttackedCreature(LinkedList<Creature> attackedArmy) {
        return attackedArmy.get(RandomGenerator.getDefault().nextInt(0, attackedArmy.size()));
    }

    private void sortArmiesBySpeed(LinkedList<Creature> armyX, LinkedList<Creature> armyY) {
        armyX.sort(Comparator.comparingInt(Creature::getSpeed).reversed());
        armyY.sort(Comparator.comparingInt(Creature::getSpeed).reversed());
    }

}
