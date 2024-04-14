package HeroesOfMightAndMagic;

import javax.naming.directory.BasicAttribute;

public class Main {
    public static void main(String[] args) {
        Creature creatureGriffin = new Griffin("Griff");
        Creature creaturePekerman = new Pekerman("Pek");
        Creature creatureSwordman = new Swordman("Sword");
        Creature creatureAngel = new Angel("Ang");

        Hero attacker = new Hero("Att", 1, 1);
        attacker.addCreature(creatureGriffin, 5);
        attacker.addCreature(creaturePekerman, 2);
        attacker.removeCreature(creatureGriffin, 3);
        attacker.getArmy();

        Hero defender = new Hero("Def", 1, 2);
        defender.addCreature(creatureSwordman, 4);
        defender.addCreature(creatureAngel, 2);
        defender.removeCreature(creatureSwordman, 2);
        defender.getArmy();

        Battlefield battlefield = new Battlefield(attacker, defender);
        System.out.println("Победил герой " + battlefield.battle().getName());
    }
}
