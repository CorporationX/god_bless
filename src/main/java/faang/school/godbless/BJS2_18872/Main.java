package faang.school.godbless.BJS2_18872;

public class Main {
    public static void main(String[] args) {
        Hero firstHero = new Hero("Arthur", "Castle");
        Hero secondHero = new Hero("Morgana", "Necropolis");

        firstHero.addCreature(new Pikeman(), 10);
        firstHero.addCreature(new Griffin(), 5);

        secondHero.addCreature(new Swordman(), 7);
        secondHero.addCreature(new Angel(), 1);

        System.out.println("Before battle:");
        System.out.println(firstHero + "\n" + secondHero);

        Battlefield battlefield = new Battlefield(firstHero, secondHero);
        battlefield.battle();

    }
}
