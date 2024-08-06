package faang.school.godbless.BJS2_18891.battle;

import faang.school.godbless.BJS2_18891.heroes.Hero;
import faang.school.godbless.BJS2_18891.units.Creature;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class BattleHero {

    private Map<BattleCreature<Creature>, Integer> battleArmy = new HashMap<>();
    public BattleHero(Hero hero) {
        hero.getArmy().forEach((creature, quantity) -> {
            BattleCreature<Creature> battleCreature = new BattleCreature<>(creature, quantity);
            battleCreature.setHero(hero);
            battleArmy.put(battleCreature, quantity);
        });
    }
}
