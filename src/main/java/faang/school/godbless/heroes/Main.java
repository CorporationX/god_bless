package faang.school.godbless.heroes;

public class Main {

    public static void main(String[] args) {
        Hero firstHero = new Hero("first", "firstFraction", 1, 1);
        Hero secondHero = new Hero("second", "secondFraction", 1, 1);

        firstHero.addCreature(new Griffin("griffin"), 83);
        firstHero.addCreature(new Pikeman("pikeman"), 15);
        firstHero.addCreature(new Swordman("swordman"), 105);

        secondHero.addCreature(new Angel("angel"), 83);
        secondHero.addCreature(new Pikeman("pikeman"), 150);

        Battlefield battlefield = new Battlefield(firstHero, secondHero);

        Hero winner = battlefield.battle();

        System.out.println("And the winner is... " + winner.getName());
    }
}
