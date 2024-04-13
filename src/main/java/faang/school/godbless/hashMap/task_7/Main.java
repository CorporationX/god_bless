package faang.school.godbless.hashMap.task_7;

import faang.school.godbless.hashMap.task_7.model.BattleField;
import faang.school.godbless.hashMap.task_7.model.creatures.*;
import faang.school.godbless.hashMap.task_7.model.heroes.Hero;

public class Main {
    public static void main(String[] args) {
        getBattleField().battle();
    }

    private static BattleField getBattleField() {
        Creature pikemanForFirstHero = new Pikeman();
        Creature griffinForFirstHero = new Griffin();
        Creature swordmanForFirstHero = new Swordman();
        Creature angelForFirstHero = new Angel();
        Creature pikemanForSecondHero = new Pikeman();
        Creature griffinForSecondHero = new Griffin();
        Creature swordmanForSecondHero = new Swordman();
        Creature angelForForSecondHero = new Angel();
        Hero ignat = new Hero("ignat", "hum", 7, 3);
        Hero magomed = new Hero("magomed", "hum", 8, 2);
        ignat.addCreature(pikemanForFirstHero, 14);
        ignat.addCreature(griffinForFirstHero, 7);
        ignat.addCreature(swordmanForFirstHero, 4);
        ignat.addCreature(angelForFirstHero, 1);
        magomed.addCreature(pikemanForSecondHero, 14);
        magomed.addCreature(griffinForSecondHero, 7);
        magomed.addCreature(swordmanForSecondHero, 4);
        magomed.addCreature(angelForForSecondHero, 1);
        return new BattleField(ignat, magomed);
    }
}
