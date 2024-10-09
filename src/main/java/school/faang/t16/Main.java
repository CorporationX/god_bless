package school.faang.t16;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Hero hero1 = new Hero("Orrin", "Castle");
        hero1.addCreature(new Pikeman(), 60);
        hero1.addCreature(new Swordsman(), 20);
        hero1.addCreature(new Angel(), 2);

        Hero hero2 = new Hero("Sylvia", "Rampart");
        hero2.addCreature(new Griffin(), 60);
        hero2.addCreature(new Swordsman(), 20);
        hero2.addCreature(new Angel(), 1);

        hero1.getArmy();
        for (Map.Entry<Creature, Integer> entry : hero1.getArmy().entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue());
        }
        System.out.println("_______________________");
        hero2.getArmy();
        for (Map.Entry<Creature, Integer> entry : hero2.getArmy().entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue());
        }
        System.out.println("_______________________");

        Battlefield battlefield = new Battlefield(hero1, hero2);
        Hero winner = battlefield.battle();

        System.out.println("Winner: " + winner.getName());
        System.out.println("Remaining army:");
        for (Map.Entry<Creature, Integer> entry : winner.getArmy().entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue());
        }
    }
}