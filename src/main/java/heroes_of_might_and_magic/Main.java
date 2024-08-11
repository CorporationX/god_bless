package heroes_of_might_and_magic;

import heroes_of_might_and_magic.creatures.Angel;
import heroes_of_might_and_magic.creatures.Griffin;

public class Main {

    public static void main(String[] args) {
        Hero hero1 = new Hero("Vitaly", "Demons", 15, 600);
        Hero hero2 = new Hero("Egor", "Angels", 10, 300);

        hero1.addCreature(new Griffin("Griffin"), 5);
        hero2.addCreature(new Angel("Angel"), 1);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        Hero winHero = battlefield.battle();

        System.out.printf("Победил герой %s%n", winHero.getName());
    }
}
