package faang.school.godbless.BJS2_18970;

public class Main {
    public static void main(String[] args) {

        Hero hero1 = new Hero("Alex", "Swords", 4, 7);
        Creature pikerman1 = new Pikeman();
        Creature swordman1 = new Swordman();
        Creature angel = new Angel();
        Creature griffin1 = new Griffin();

        hero1.addCreature(pikerman1, 1);
        hero1.addCreature(swordman1, 1);
        hero1.addCreature(angel, 1);
        hero1.addCreature(griffin1, 1);

        Hero hero2 = new Hero("Dan", "Angels", 6, 4);
        Creature pikerman2 = new Pikeman();
        Creature pikerman3 = new Pikeman();
        Creature swordman2 = new Swordman();
        Creature griffin2 = new Griffin();

        hero2.addCreature(pikerman2, 1);
        hero2.addCreature(pikerman3, 1);
        hero2.addCreature(swordman2, 1);
        hero2.addCreature(griffin2, 1);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        Hero winner = battlefield.battle();
        System.out.println("The winner is " + winner.getName());
    }
}

