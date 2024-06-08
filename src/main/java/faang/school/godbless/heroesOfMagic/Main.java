package faang.school.godbless.heroesOfMagic;

public class Main {

    public static void main(String[] args) {
        Angel angel = new Angel(2);
        Griffin griffin = new Griffin(2);
        Pikeman pikeman = new Pikeman(2);
        Swordman swordman = new Swordman(2);

        Hero firstHero = new Hero("first hero", "fraction 1", 10, 10);

        firstHero.addCreature(angel, 2);
        firstHero.addCreature(griffin, 1);

        Hero secondHero = new Hero("second hero", "fraction 2", 11, 11);

        secondHero.addCreature(pikeman, 3);
        secondHero.addCreature(swordman, 1);


        Battlefield battlefield = new Battlefield(firstHero, secondHero);
        System.out.println("the winner of battle is: " + battlefield.battle().getName());
    }
}
