package faang.school.godbless.BJS2_4128;

public class Main {
    public static void main(String[] args) {
        Hero hero1 = new Hero("Герой 1", "Фракция 1");
        Hero hero2 = new Hero("Герой 2", "Фракция 2");

        hero1.addCreature(new Pikeman(), 10);
        hero1.addCreature(new Griffin(), 5);

        hero2.addCreature(new Swordman(), 8);
        hero2.addCreature(new Angel(), 3);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        Hero winner = battlefield.battle();
        System.out.println("Winner: " + winner.getName());
    }
}