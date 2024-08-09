package faang.school.godbless.Heroes;

public class Main {
    public static void main(String[] args) {
        Hero hero1 = new Hero("Sir Roland", "Castle", 5);
        Hero hero2 = new Hero("Lord Haart", "Necropolis", 5);

        hero1.addCreature(new Pikeman(), 100);
        hero1.addCreature(new Griffin(), 50);
        hero1.addCreature(new Swordman(), 75);

        hero2.addCreature(new Pikeman(), 120);
        hero2.addCreature(new Griffin(), 40);
        hero2.addCreature(new Angel(), 10);

        System.out.println(hero1);
        System.out.println("Army of " + hero1.getName() + ": " + hero1.getArmy());
        System.out.println();

        System.out.println(hero2);
        System.out.println("Army of " + hero2.getName() + ": " + hero2.getArmy());
        System.out.println();

        BattleField battlefield = new BattleField(hero1, hero2);
        Hero winner = battlefield.battle();

        if (winner != null) {
            System.out.println("The winner is: " + winner.getName());
        } else {
            System.out.println("The battle ended in a tie.");
        }
    }
}
