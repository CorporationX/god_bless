package heroes;

import heroes.item.Angel;
import heroes.item.Griffin;
import heroes.item.Pikeman;
import heroes.item.Swordman;

public class Main {
    public static void main(String[] args) {

        Hero hero1 = new Hero("Dracula", 1, 5, 3);
        Hero hero2 = new Hero("Superman", 1, 2, 1);

        hero1.addCreature(new Angel(), 5);
        hero1.addCreature(new Angel(), 10);
        hero1.addCreature(new Griffin(), 10);

        hero2.addCreature(new Pikeman(), 10);
        hero2.addCreature(new Swordman(), 10);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        System.out.println(battlefield.battle().getName() + " is WINNER!");
    }
}
