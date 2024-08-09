package faang.school.godbless.BJS2_18891;

import faang.school.godbless.BJS2_18891.battle.BattleCreature;
import faang.school.godbless.BJS2_18891.battle.BattleHero;
import faang.school.godbless.BJS2_18891.units.Creature;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Battlefield {

    public void battle(BattleHero battleHero1, BattleHero battleHero2) {
        List<BattleCreature<Creature>> hero1BattleArmy = armyAsSortedOnSpeedDescList(battleHero1);
        List<BattleCreature<Creature>> hero2BattleArmy = armyAsSortedOnSpeedDescList(battleHero2);

        int count = 1;
        int army1Index = 0;
        int army2Index = 0;
        Random random = new Random();
        int randomIndex;

        while (!hero1BattleArmy.isEmpty() && !hero2BattleArmy.isEmpty()) {
            if (count % 2 != 0) {
                randomIndex = random.nextInt(hero2BattleArmy.size());
                BattleCreature<Creature> defendingCreature = hero2BattleArmy.get(randomIndex);
                hero1BattleArmy.get(army1Index).makeDamage(defendingCreature);
                if (defendingCreature.getQuantity() == 0) {
                    hero2BattleArmy.remove(randomIndex);
                    System.out.println(defendingCreature.getName() + " удален у Героя 2");
                    if (army2Index != 0) {
                        army2Index--;
                    }
                }
                army1Index++;
                if (army1Index == hero1BattleArmy.size()) army1Index = 0;
            } else {
                randomIndex = random.nextInt(hero1BattleArmy.size());
                BattleCreature<Creature> defendingCreature = hero1BattleArmy.get(randomIndex);
                hero2BattleArmy.get(army2Index).makeDamage(defendingCreature);
                if (defendingCreature.getQuantity() == 0) {
                    hero1BattleArmy.remove(randomIndex);
                    System.out.println(defendingCreature.getName() + " удален у Героя 1");
                    if (army1Index != 0) {
                        army1Index--;
                    }
                }
                army2Index++;
                if (army2Index == hero2BattleArmy.size()) army2Index = 0;
            }
            count++;
        }

        if (hero1BattleArmy.isEmpty()) {
            System.out.println("Герой 2 побеждает.");
            System.out.println("Оставшаяся армия у Героя 2:");
            hero2BattleArmy.forEach(a -> System.out.println(a.getName() + ": " + a.getQuantity()));
        } else {
            System.out.println("Герой 1 побеждает.");
            System.out.println("Оставшаяся армия у Героя 1:");
            hero1BattleArmy.forEach(a -> System.out.println(a.getName() + ": " + a.getQuantity()));
        }

    }

    private List<BattleCreature<Creature>> armyAsSortedOnSpeedDescList(BattleHero battleHero) {
        return new ArrayList<>(battleHero.getBattleArmy().keySet().stream()
                .sorted((a, b) -> b.getSpeed() - a.getSpeed())
                .toList()
        );
    }
}
