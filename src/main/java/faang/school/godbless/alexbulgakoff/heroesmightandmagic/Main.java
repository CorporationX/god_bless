package faang.school.godbless.alexbulgakoff.heroesmightandmagic;

/**
 * @author Alexander Bulgakov
 */

public class Main {

    public static void main(String[] args) {
        Hero attacker = new Hero("Attacker",  "Red Arrow", 40, 5);
        Hero defender = new Hero("Defender",  "Stinging Snake", 35, 5);

        Creature angel = new Angel("Amaliel");
        Creature griffin = new Griffin("Sunstorm");
        Creature pikeman = new Pikeman("Pikeman");
        Creature swordman = new Swordman("Swordman");

        attacker.addCreature(angel, 5);
        attacker.addCreature(griffin, 5);
        attacker.addCreature(pikeman, 50);
        attacker.addCreature(swordman, 100);

        defender.addCreature(angel, 4);
        defender.addCreature(griffin, 6);
        defender.addCreature(pikeman, 60);
        defender.addCreature(swordman, 100);
    }
}
