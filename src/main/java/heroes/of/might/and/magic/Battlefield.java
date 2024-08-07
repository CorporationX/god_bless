package heroes.of.might.and.magic;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Battlefield {

    public static void main(String[] args) {
        Hero hero1 = new Hero("Hero 1", "fraction1", 10, 5);
        Hero hero2 = new Hero("Hero 2", "fraction2", 10, 5);

        hero1.addCreature(new Angel(), 5);
        hero1.addCreature(new Angel(), 2);
        hero1.removeCreature(new Angel(), 1);
        hero1.addCreature(new Griffin(), 8);

        hero2.addCreature(new Pikeman(), 50);
        hero2.addCreature(new Swordman(), 30);

        Hero winner = battle(hero1, hero2);
        System.out.println("Победил герой: " + winner.getName());
    }

    public static Hero battle(Hero attacker, Hero defender) {
        Random random = new Random();
        List<Hero> heroes = Arrays.asList(attacker, defender);
        return heroes.get(random.nextInt(heroes.size()));
    }
}
