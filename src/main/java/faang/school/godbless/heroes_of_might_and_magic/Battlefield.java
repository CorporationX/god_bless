package faang.school.godbless.heroes_of_might_and_magic;

import java.util.ArrayList;

public class Battlefield {
    private final Hero HERO_LEFT = new Hero(
            "Elf",
            "Elf",
            100,
            10,
            new ArrayList<>()
    );
    private final Hero HERO_RIGHT = new Hero(
            "Dwarf",
            "Dwarf",
            140,
            3,
            new ArrayList<>()
    );

    public void battle(Hero heroLeft, Hero heroRight) {
        if (heroLeft.getArmy().size() > heroRight.getArmy().size()) {
            System.out.println(heroLeft.getFraction() + " wins!");
        } else {
            System.out.println(heroRight.getFraction() + " wins!");
        }
    }

    public static void main(String[] args) {
        Hero heroLeft = new Hero("Elf", "Elf", 100, 10, new ArrayList<>());
        Hero heroRight = new Hero("Dwarf", "Dwarf", 140, 3, new ArrayList<>());

        heroLeft.addCreature(new Pikeman(), 3);
        heroLeft.addCreature(new Angel(), 10);
        heroLeft.addCreature(new Griffin(), 37);

        heroRight.addCreature(new Angel(), 10);
        heroRight.addCreature(new Pikeman(), 11);
        heroRight.addCreature(new Swordman(), 3);
        heroRight.addCreature(new Griffin(), 7);

        Battlefield battlefield = new Battlefield();
        battlefield.battle(heroLeft, heroRight);
    }
}
