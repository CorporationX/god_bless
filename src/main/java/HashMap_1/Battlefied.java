package HashMap_1;

import HashMap_1.Army.Creature;
import HashMap_1.Army.Creatures.Angel;
import HashMap_1.Army.Creatures.Griffin;
import HashMap_1.Army.Creatures.Pikeman;
import HashMap_1.Army.Creatures.Swordman;
import HashMap_1.Army.Hero;

public class Battlefied {

    private Hero orderHero = new Hero("Vasya Pupkin", 20, "Order");
    private Hero chaosHero = new Hero("Troll", 80, "chaos");

    public static Hero battle() {
        Battlefied demoBattlefied = new Battlefied();
        Angel angel = new Angel(((int) (Math.random() * 3)));
        Griffin griffin = new Griffin(((int) (Math.random() * 5)));
        Swordman swordman = new Swordman(((int) (Math.random() * 10)));
        Pikeman pikeman = new Pikeman(((int) (Math.random() * 10)));
        demoBattlefied.chaosHero.addCreature(griffin, angel.getQuantity());
        demoBattlefied.chaosHero.addCreature(pikeman, pikeman.getQuantity());
        demoBattlefied.orderHero.addCreature(angel, angel.getQuantity());
        demoBattlefied.orderHero.addCreature(swordman, swordman.getQuantity());
        return battle(demoBattlefied.orderHero, demoBattlefied.chaosHero);
    }

    public static Hero battle(Hero firstHero, Hero secondHero) {
        while ((firstHero.getArmy().size() > 0) && (secondHero.getArmy().size() > 0)) {
            int rand = ((int) (Math.random() * 2));
            if (rand == 1)
                round(firstHero, secondHero);
            else
                round(secondHero, firstHero);
        }
        if (firstHero.getArmy().size() > 0)
            return firstHero;
        else
            return secondHero;
    }

    private static void round(Hero attackHero, Hero defendHero) {
        int randAttack = (int) Math.floor(Math.random() * (attackHero.getArmy().size()));
        int randDefend = (int) Math.floor(Math.random() * (defendHero.getArmy().size()));
        Creature attackCreature = attackHero.getArmy().get(randAttack);
        Creature defendCreature = defendHero.getArmy().get(randDefend);
        int resultRound = attackCreature.getDamage(defendCreature);
        if (resultRound <= 0) {
            defendHero.removeCreature(defendCreature, 1);
            System.out.println(attackCreature.getName() + " from army of " + attackHero.getName() + " kill " + defendCreature.getName() + " from army of " + defendHero.getName());
        } else {
            System.out.println(defendCreature.getName() + " from army of " + defendHero.getName() + " protected by attak " + attackCreature.getName() + " from army of " + attackHero.getName());
        }
    }

}
