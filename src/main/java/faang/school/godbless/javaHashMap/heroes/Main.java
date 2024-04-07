package faang.school.godbless.javaHashMap.heroes;

import faang.school.godbless.javaHashMap.heroes.creatures.Angel;
import faang.school.godbless.javaHashMap.heroes.creatures.Griffin;
import faang.school.godbless.javaHashMap.heroes.creatures.Pikeman;
import faang.school.godbless.javaHashMap.heroes.creatures.Swordsman;

public class Main {
    public static void main(String[] args) {
        Hero allianceHero = new Hero("Artos", "Alliance", 5, 250);

        Pikeman pikeman = new Pikeman("Dwarf pikeman");
        Swordsman swordsman = new Swordsman("Human swordsman");
        Angel angel = new Angel("Just angel");

        allianceHero.addCreature(pikeman, 5);
        allianceHero.addCreature(swordsman, 10);
        allianceHero.addCreature(angel, 1);

        System.out.println("Hero's army at start point:");
        allianceHero.showArmy();


        System.out.println("Removing 7 " + pikeman.getName() + ".");

        allianceHero.removeCreature(pikeman, 7);

        System.out.println("Hero's army at this point:");
        allianceHero.showArmy();


        try {
            System.out.println("Trying to summon 7 more swordsmen.\n");
            allianceHero.addCreature(swordsman, 7);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Hero's army at this point:");
        allianceHero.showArmy();


        Hero hordeHero = new Hero("Silvana", "Horde", 5, 250);

        Pikeman trollPikeman = new Pikeman("Troll pikeman");
        Swordsman orcSwordsman = new Swordsman("Orc swordsman");
        Griffin griffin = new Griffin("Powerful griffin");

        hordeHero.addCreature(trollPikeman, 5);
        hordeHero.addCreature(orcSwordsman, 10);
        hordeHero.addCreature(griffin, 1);

        System.out.println("Hero's army at start point:");
        hordeHero.showArmy();


        System.out.println("\n\n\n\n");

        System.out.println("Now it's time to see the result of great battle between two great heroes!");

        Battlefield battlefield = new Battlefield(allianceHero, hordeHero);

        System.out.println("\n");

        battlefield.battle();

        System.out.println("\n");

    }
}
