package faang.school.godbless.homm;

import faang.school.godbless.homm.battle.Battlefield;
import faang.school.godbless.homm.hero.Hero;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero("Erik");
        Hero enemy = new Hero("Vaider");
        Battlefield battlefield = new Battlefield(hero, enemy);

        battlefield.battle();
    }
}
