package faang.school.godbless.bjs219140;

public class Main {
    public static void main(String[] args) {
        Hero hero1 = new Hero("Arthur", "Knights", 100, 5);
        Hero hero2 = new Hero("Morgan", "Wizards", 120, 7);
        Creature pikeman = new Pikeman();
        Creature griffin = new Griffin();
        Creature swordman = new Swordman();
        Creature angel = new Angel();
        Battlefield battlefield = new Battlefield(hero1, hero2);

        hero1.addCreature(pikeman, 11);
        hero1.addCreature(angel, 7);
        hero2.addCreature(swordman, 10);
        hero2.addCreature(griffin, 8);

        battlefield.battle();
    }
}
