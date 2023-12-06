package faang.school.godbless.BJS2_511;

import faang.school.godbless.BJS2_511.Battlefield;
import faang.school.godbless.BJS2_511.Hero;
import faang.school.godbless.BJS2_511.creatures.Griffin;
import faang.school.godbless.BJS2_511.creatures.Pikeman;

public class Main {
    public static void main(String[] args) {
        Pikeman pikeman = new Pikeman(100);
        Griffin griffin = new Griffin(20);

        Hero hero1 = new Hero("Hero1", "fraction1");
        Hero hero2 = new Hero("Hero2", "fraction2");

        hero1.addCreature(pikeman, 50);
        hero1.addCreature(griffin, 10);

        hero2.addCreature(pikeman, 30);
        hero2.addCreature(griffin, 30);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        Hero winner = battlefield.battle();

        System.out.println("Winner: " + winner.getName() + " from " + winner.getFraction());
    }
}
