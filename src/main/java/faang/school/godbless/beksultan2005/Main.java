package faang.school.godbless.beksultan2005;

public class Main {
    public static void main(String[] args) {
        Hero hero1 = new Hero("Arthur", 3,1);
        Hero hero2 = new Hero("Morgana", 4,2);

        Creature pikeman = new Pikeman();
        Creature griffin = new Griffin();
        Creature swordman = new Swordman();
        Creature angel = new Angel();

        hero1.addCreature(pikeman, 10);
        hero1.addCreature(griffin, 5);
        hero1.addCreature(swordman, 7);
        hero1.addCreature(angel, 8);

        hero2.addCreature(pikeman, 15);
        hero2.addCreature(griffin, 4);
        hero2.addCreature(swordman, 6);
        hero2.addCreature(angel, 3);

        hero1.removeCreature(angel, 1);

        hero1.getArmy();
        hero2.getArmy();

        Battlefield battlefield = new Battlefield(hero1, hero2);
        battlefield.battle();
    }
}

