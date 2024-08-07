package faang.school.godbless.javahashmap.herouse;

public class Main {

    private static final Creature PIKEMAN = new Pikeman();
    private static final Creature SWORDMAN = new Swordman();
    private static final Creature GRIFFIN = new Griffin();
    private static final Creature ANGEL = new Angel();

    public static void main(String[] args) {
        Hero hero1 = new Hero("Alex", "Human", 1, 0);
        hero1.addCreature(PIKEMAN, 30);
        hero1.addCreature(SWORDMAN, 15);
        hero1.addCreature(GRIFFIN, 10);
        hero1.addCreature(ANGEL, 3);

        Hero hero2 = new Hero("Pavel", "Human", 2, 1);
        hero2.addCreature(PIKEMAN, 10);
        hero2.addCreature(SWORDMAN, 15);
        hero2.addCreature(GRIFFIN, 15);
        hero2.addCreature(ANGEL, 4);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        battlefield.battle();
    }
}
