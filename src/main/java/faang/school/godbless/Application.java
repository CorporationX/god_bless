package faang.school.godbless;

public class Application {
    public static void main(String... args) {
        Creature pikeman = new Pikeman();
        Creature griffin = new Griffin();
        Creature swordman = new Swordman();
        Creature angel = new Angel();

        Hero hero1 = new Hero("Test", "Test", 10L,10L);
        hero1.addCreature(pikeman, 1);
        hero1.addCreature(griffin, 1);
        hero1.addCreature(swordman, 1);
        hero1.addCreature(angel, 1);

        Hero hero2 = new Hero("Test2", "Test2", 10L,10L);
        hero2.addCreature(pikeman, 1);
        hero2.addCreature(griffin, 1);
        hero2.addCreature(swordman, 1);
        hero2.addCreature(angel, 1);

        Battlefield battlefield = new Battlefield(hero1, hero2);

        System.out.println(battlefield.battle());
    }
}
