package faang.school.godbless.BJS2_18872;

public class Main {
    public static void main(String[] args) {
        Hero hero1 = new Hero("Arthur", "Castle");
        Hero hero2 = new Hero("Morgana", "Necropolis");

        hero1.addCreature(new Pikeman(), 10);
        hero1.addCreature(new Griffin(), 5);

        hero2.addCreature(new Swordman(), 7);
        hero2.addCreature(new Angel(), 1);

        System.out.println("Before battle:");
        System.out.println(hero1.getName() + " has an army of: " + hero1.getArmy());
        System.out.println(hero2.getName() + " has an army of: " + hero2.getArmy());

        Battlefield battlefield = new Battlefield(hero1, hero2);
        Hero winner = battlefield.battle();

        System.out.println("After battle:");
        if (winner != null) {
            System.out.println("Winner: " + winner.getName());
        }
    }
}
