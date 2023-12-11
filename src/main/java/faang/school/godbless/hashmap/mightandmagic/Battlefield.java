package faang.school.godbless.hashmap.mightandmagic;

import faang.school.godbless.hashmap.mightandmagic.creatures.Creature;

public class Battlefield {

    public Hero battle(Hero heroX, Hero heroY) {
        sortArmiesBySpeed(heroX, heroY);

        while (true) {
            attack(heroX, heroY);
            if(heroY.getArmy().isEmpty()) {
                return heroX;
            }
            attack(heroY, heroX);
            if(heroX.getArmy().isEmpty()) {
                return heroY;
            }
        }
    }

    private void attack(Hero attackingHero, Hero attackedHero) {
        Creature attackingCreature = attackingHero.getNextAttackingCreature();
        Creature attackedCreature = attackedHero.rollAttackedCreature();

        attackedCreature.takeDamage(attackingCreature.getDamage());
        attackingHero.returnCreatureToQueue(attackingCreature);
        if(attackedCreature.getQuantity() <= 0) {
            attackedHero.removeDeadCreature(attackedCreature);
        }
    }

    private void sortArmiesBySpeed(Hero heroX, Hero heroY) {
        heroX.sortArmyForBattle();
        heroY.sortArmyForBattle();
    }

}
