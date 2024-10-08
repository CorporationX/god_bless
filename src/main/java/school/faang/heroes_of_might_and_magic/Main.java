package school.faang.heroes_of_might_and_magic;

public class Main {
    public static void main(String[] args) {
        Hero MY_HERO = new Hero("Maks", "Cyclops", 550, 7);
        MY_HERO.addCreature(new Griffin("Griff"), 15);
        MY_HERO.addCreature(new Swordman("Snow"), 25);
        MY_HERO.addCreature(new Pikeman("Rocki"), 90);
        MY_HERO.addCreature(new Angel("Fire"), 10);
        Hero ENEMY_HERO = new Hero("Cyclop", "Cyclops", 330, 4);
        ENEMY_HERO.addCreature(new Griffin("Zloy"), 150);
        Battlefield battlefield = new Battlefield(MY_HERO, ENEMY_HERO);
    }
}