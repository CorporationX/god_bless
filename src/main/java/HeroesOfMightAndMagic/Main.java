package HeroesOfMightAndMagic;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Hero heroArthur = new Hero("Arthur", "Knights", 1000, 10);
        heroArthur.addCreature(new Griffin("Griffin"), random.nextInt(100));
        heroArthur.addCreature(new Angel("Angel"), random.nextInt(100));
        heroArthur.addCreature(new Pikeman("Pikeman"), new Random().nextInt(100));

        Hero heroVlad = new Hero("Vlad", "Necropolis", 1200, 12);
        heroVlad.addCreature(new Griffin("Griffin"), random.nextInt(150));
        heroVlad.addCreature(new Angel("Angel"), random.nextInt(50));
        heroVlad.addCreature(new Pikeman("Pikeman"), random.nextInt(100));

        Hero heroElena = new Hero("Elena", "Elves", 800, 8);
        heroElena.addCreature(new Griffin("Griffin"), random.nextInt(50));
        heroElena.addCreature(new Angel("Angel"), random.nextInt(100));
        heroElena.addCreature(new Pikeman("Pikeman"), random.nextInt(150));

        heroArthur.getArmy();
        heroVlad.getArmy();
        heroElena.getArmy();

        Battlefield.battle(heroArthur, heroVlad);
        Battlefield.battle(heroElena, heroArthur);
    }
}
