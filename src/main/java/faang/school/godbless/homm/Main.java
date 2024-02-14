package faang.school.godbless.homm;

public class Main {
    public static void main(String[] args) {
        Hero hero1 = new Hero("Inoael", "Human", 1, 1);
        Hero hero2 = new Hero("Afradey", "Human", 1, 1);
        hero1.addCreature(new Pikeman(), 2);
        hero1.addCreature(new Pikeman(), 1);
        hero1.addCreature(new Swordman(), 2);
        hero1.addCreature(new Angel(), 1);

        hero2.addCreature(new Pikeman(), 3);
        hero2.addCreature(new Swordman(), 3);


        Battlefield battlefield = new Battlefield(hero1, hero2);
        Hero winner = battlefield.battle();
        System.out.println(winner.getName());

    }
}
