package faang.school.godbless;

import faang.school.godbless.units.Angel;
import faang.school.godbless.units.Creature;
import faang.school.godbless.units.Griffin;

public class Battlefield {

    public static void battle(Hero attacker, Hero defender) {
        if (attacker.getCreatures().isEmpty() && defender.getCreatures().isEmpty()) {
            System.out.println("DRAW");
            return;
        } else if (attacker.getCreatures().isEmpty()) {
            System.out.println("Deffender Win");
            return;
        } else if (defender.getCreatures().isEmpty()) {
            System.out.println("Attacker Win");
            return;
        }

        int attackerDamage = attacker.getCreatures().stream().mapToInt(Creature::getDamage).sum();
        int defenderDamage = defender.getCreatures().stream().mapToInt(Creature::getDamage).sum();

        if (attackerDamage - defenderDamage <= 0) {
            System.out.println("The defender has a " + (Math.abs(attackerDamage - defenderDamage)) + " damage advantage");
            System.out.println("Defender wins");
        } else {
            System.out.println("The attacker has a " + (attackerDamage - defenderDamage) + " damage advantage");
            System.out.println("Attacker wins");
        }

    }

    public static void main(String[] args) {

        Hero heroFirst = new Hero("Orrin", "Knight", 100, 1);
        Hero heroSecond = new Hero("Kyrre", "Ranger", 100, 1);

        Griffin griffin = new Griffin();
        Angel angel = new Angel();

        heroFirst.addCreature(griffin, 100);
        heroFirst.addCreature(griffin, 100);
        heroFirst.removeCreature(griffin, 10);
        heroFirst.removeCreature(griffin, 10);

        heroSecond.addCreature(griffin, 200);
        battle(heroFirst, heroSecond);

        heroFirst.addCreature(angel, 1);
        battle(heroFirst, heroSecond);
    }
}
