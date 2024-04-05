package faang.school.godbless.heroes_of_might_and_Magic;

import faang.school.godbless.heroes_of_might_and_Magic.creatures.Angel;
import faang.school.godbless.heroes_of_might_and_Magic.creatures.Griffin;
import faang.school.godbless.heroes_of_might_and_Magic.creatures.Pikeman;
import faang.school.godbless.heroes_of_might_and_Magic.creatures.Swordman;

public class Main {

    public static void main(String[] args) {
        Hero firstHero = new Hero("Hero1", "People", 1000, 12);
        Hero secondHero = new Hero("Hero2", "People", 1000, 12);

        firstHero.addCreature(new Griffin("Griffin", 2, 11), 3);
        secondHero.addCreature(new Griffin("GriffinDark", 12, 11), 2);
        firstHero.addCreature(new Pikeman("Pikeman", 1, 11), 5);
        secondHero.addCreature(new Swordman("SwordmanDark", 22, 11), 1);
        firstHero.addCreature(new Swordman("Swordman", 100, 11), 2);
        secondHero.addCreature(new Angel("Angel", 10, 10), 10);

        secondHero.removeCreature(new Griffin("GriffinDark", 12, 11), 1);

        Battlefield battlefield = new Battlefield(firstHero, secondHero);

        System.out.println(battlefield.battle());
    }
}
