package heroes_of_might_and_magic;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Hero firstHero = new Hero("John", "Theif", 1, 5);
        Hero secondHero = new Hero("Jane", "Warrior", 10, 50);

        Creature angel = new Angel("Angel", 5, 5, 5, 5);
        Creature griffin = new Griffin("Dragon", 5, 5, 5, 5);
        Creature pikeman = new Pikeman("Pikeman", 5, 5, 5, 5);
        Creature swordsman = new Swordman("Swordman", 5, 5, 5, 5);

        List<Creature> creatures = List.of(angel, griffin, pikeman, swordsman);

        for (Creature creature : creatures) {
            firstHero.addCreature(creature, (int) Math.floor(Math.random() * 5) + 1);
            secondHero.addCreature(creature, (int) Math.floor(Math.random() * 5) + 1);
        }

        Battlefield battlefield = new Battlefield();
        battlefield.battle(firstHero, secondHero);
    }
}
