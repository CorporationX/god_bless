package ru.kraiush.BJS2_32817;

public class Main {

    public static void main(String[] args) {
        Hero attacker = new Hero("Warrior", "League", 1);
        Hero defender = new Hero("Ogre", "Horde", 2);

        Creature pikeman = new Pikeman();
        Creature griffin = new Griffin();
        Creature swordman = new Swordman();
        Creature angel = new Angel();

        attacker.addCreature(pikeman, 7);
        attacker.addCreature(angel, 8);

        defender.addCreature(griffin, 4);
        defender.addCreature(swordman, 1);

        Battlefield battlefield = new Battlefield(attacker, defender);

        System.out.println("Hero 1 army: ");
        for (Creature creature : attacker.getArmy()) {
            System.out.println("Name:" + creature.getName() +
                    ", Level = " + creature.getLevel() +
                    ", Attack = " + creature.getAttack() +
                    ", Defense = " + creature.getDefense() +
                    ", Speed = " + creature.getSpeed());
        }
        System.out.println("Hero 2 army: ");
        for (Creature creature : defender.getArmy()) {
            System.out.println("Name:" + creature.getName() +
                    ", Level = " + creature.getLevel() +
                    ", Attack = " + creature.getAttack() +
                    ", Defense = " + creature.getDefense() +
                    ", Speed = " + creature.getSpeed());
        }

        attacker.removeCreature(pikeman, 5);
        attacker.removeCreature(angel, 4);

        System.out.println("______________");
        System.out.println("Hero 1 army: ");
        for (Creature creature : attacker.getArmy()) {
            System.out.println("Name:" + creature.getName() +
                    ", Level = " + creature.getLevel() +
                    ", Attack = " + creature.getAttack() +
                    ", Defense = " + creature.getDefense() +
                    ", Speed = " + creature.getSpeed());
        }
        System.out.println("Hero 2 army: ");
        for (Creature creature : defender.getArmy()) {
            System.out.println("Name:" + creature.getName() +
                    ", Level = " + creature.getLevel() +
                    ", Attack = " + creature.getAttack() +
                    ", Defense = " + creature.getDefense() +
                    ", Speed = " + creature.getSpeed());
        }

        System.out.println("A winner is " + battlefield.battle());
    }
}
