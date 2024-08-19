package faang.school.godbless.heroes;

public class Main {
    public static void main(String[] args) {
        Hero hero1 = new Hero("Red", "Red", 100, 100);
        Hero hero2 = new Hero("White", "White", 100, 100);

        hero1.addCreature(new Pikeman(100), 100);
        hero1.addCreature(new Griffin(50), 50);
        hero2.addCreature(new Swordman(80), 80);
        hero2.addCreature(new Angel(70), 70);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        Hero winner = battlefield.battle();

        if (winner != null) {
            System.out.println("The winner is " + winner.getName());
        } else {
            System.out.println("The battle ended in a draw.");
        }
    }
}
