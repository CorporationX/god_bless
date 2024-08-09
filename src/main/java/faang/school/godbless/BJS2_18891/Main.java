package faang.school.godbless.BJS2_18891;

import faang.school.godbless.BJS2_18891.battle.BattleHero;
import faang.school.godbless.BJS2_18891.heroes.Hero;
import faang.school.godbless.BJS2_18891.units.Angel;
import faang.school.godbless.BJS2_18891.units.Griffin;
import faang.school.godbless.BJS2_18891.units.Pikeman;
import faang.school.godbless.BJS2_18891.units.Swordman;

public class Main {

    public static void main(String[] args) {

        Hero hero1 = new Hero("Герой 1");
        Hero hero2 = new Hero("Герой 2");

        hero1.addCreature(new Angel(), 2);
        hero1.addCreature(new Swordman(), 5);
        hero1.addCreature(new Griffin(), 7);
        hero1.addCreature(new Pikeman(), 10);

        hero2.addCreature(new Angel(), 1);
        hero2.addCreature(new Swordman(), 7);
        hero2.addCreature(new Griffin(), 5);
        hero2.addCreature(new Pikeman(), 15);

        BattleHero battleHero1 = new BattleHero(hero1);
        BattleHero battleHero2 = new BattleHero(hero2);

        Battlefield battlefield = new Battlefield();

        battlefield.battle(battleHero1, battleHero2);

    }
}
