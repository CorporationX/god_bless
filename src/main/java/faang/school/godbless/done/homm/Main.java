package faang.school.godbless.done.homm;

import faang.school.godbless.done.homm.battle.Battlefield;
import faang.school.godbless.done.homm.hero.Hero;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero("Erik");
        Hero enemy = new Hero("Vaider");
        Battlefield battlefield = new Battlefield(hero, enemy);

        battlefield.battle();
    }
}
