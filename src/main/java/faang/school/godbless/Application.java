package faang.school.godbless;

import faang.school.godbless.HeroesOfMightAndMagic.battlefield.*;
import faang.school.godbless.HeroesOfMightAndMagic.creatures.Angel;
import faang.school.godbless.HeroesOfMightAndMagic.creatures.Griffin;
import faang.school.godbless.HeroesOfMightAndMagic.creatures.Pikeman;
import faang.school.godbless.HeroesOfMightAndMagic.creatures.Swordman;
import faang.school.godbless.HeroesOfMightAndMagic.heroes.Hero;

public class Application {
    public static void main(String[] args) {
        Hero hero1 = createHero1();
        Hero hero2 = createHero2();

        Battlefield battlefield = new Battlefield(hero1, hero2);
        battlefield.battle();
    }

    private static Hero createHero1() {
        System.out.println("Creating Hero 1");
        Hero hero = new Hero("Hero 1", "Faction 1", 1, 2);
        System.out.println(hero.getName() + " got 2 Angel creature");
        hero.addCreature(new Angel(), 2);
        System.out.println(hero.getName()  + " got 19 Pikeman creature");
        hero.addCreature(new Pikeman(), 19);

        return hero;
    }

    private static Hero createHero2() {
        System.out.println("Creating Hero 2");
        Hero hero = new Hero("Hero 2", "Faction 2", 4, 5);
        System.out.println(hero.getName() + " got 3 Angel creature");
        hero.addCreature(new Angel(), 3);
        System.out.println(hero.getName() + " got 4 Griffin creature");
        hero.addCreature(new Griffin(), 4);
        System.out.println(hero.getName() + " got 2 Swordman creature");
        hero.addCreature(new Swordman(), 2);
        System.out.println(hero.getName()  + " got 100 Pikeman creature");
        hero.addCreature(new Pikeman(), 100);

        return hero;
    }
}