package faang.school.godbless;

public class Application {
    public static void main(String[] args) {
        Hero hero1 = new Hero("Sir Christian", "Castle", 500, 10);
        Hero hero2 = new Hero("Vey", "Necropolis", 300, 8);

        hero1.addCreature(new Pikeman(), 10);
        hero1.addCreature(new Swordman(), 5);

        hero2.addCreature(new Griffin(), 6);
        hero2.addCreature(new Angel(), 2);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        Hero winner = battlefield.battle();

        if (winner != null) {
            System.out.println("Winner: " + winner.getArmy());
        } else {
            System.out.println("It's a draw!");
        }
    }
}