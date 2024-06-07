package faang.school.godbless.heroes_of_might_and_magic;

public class Main {
    public static void main(String[] args) {
        Hero firstHero = new Hero("Alex", "Some fraction", 2, 3);
        Hero secondHero = new Hero("Julia", "Another fraction", 2, 2);
        Battlefield battlefield = new Battlefield(firstHero, secondHero);

        firstHero.addCreature(new Angel(), 1);
        firstHero.addCreature(new Swordman(), 2);
        firstHero.addCreature(new Griffin(), 5);
        firstHero.addCreature(new Pikeman(), 7);

        secondHero.addCreature(new Angel(), 2);
        secondHero.addCreature(new Swordman(), 3);
        secondHero.addCreature(new Griffin(), 5);
        secondHero.addCreature(new Pikeman(), 8);

        battlefield.battle();
    }
}
