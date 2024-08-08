package faang.school.godbless.HeroesOfMightAndMagic.battlefield;

import faang.school.godbless.HeroesOfMightAndMagic.creatures.Creature;
import faang.school.godbless.HeroesOfMightAndMagic.heroes.Hero;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class Battlefield {
    private Hero hero1;
    private Hero hero2;

    public void battle() {
        System.out.println("Battle between " + hero1.getName() + " and " + hero2.getName() + " started");

        List<Creature> hero1ArmyList = new ArrayList<>(hero1.getArmy().keySet());
        List<Creature> hero2ArmyList = new ArrayList<>(hero2.getArmy().keySet());

        int hero1Index = 0;
        int hero2Index = 0;

        while (hero1.isAlive() && hero2.isAlive()) {
            RoundResult hero1Result = performRound(hero1, hero2, hero1ArmyList, hero1Index, hero2ArmyList, hero2Index);
            hero1Index = hero1Result.getAttackerIndex();
            hero2Index = hero1Result.getDefenderIndex();

            RoundResult hero2Result = performRound(hero2, hero1, hero2ArmyList, hero2Index, hero1ArmyList, hero1Index);
            hero2Index = hero2Result.getAttackerIndex();
            hero1Index = hero2Result.getDefenderIndex();
        }

        declareWinner();
    }

    private RoundResult performRound(Hero attackerHero, Hero defenderHero, List<Creature> attackerArmyList, int attackerIndex, List<Creature> defenderArmyList, int defenderIndex) {
        if (!attackerArmyList.isEmpty()) {
            attackerIndex = adjustIndex(attackerIndex, attackerArmyList.size());
            Creature attackerCreature = attackerArmyList.get(attackerIndex);

            Optional<Creature> deadCreature = performAttack(attackerHero, defenderHero, attackerCreature);

            if (deadCreature.isPresent()) {
                int deadCreatureIndex = defenderArmyList.indexOf(deadCreature.get());
                removeDeadCreature(defenderArmyList, deadCreature.get());
                if (deadCreatureIndex < defenderIndex) {
                    defenderIndex--;
                }
            }

            attackerIndex++;
        }
        return new RoundResult(attackerIndex, defenderIndex);
    }

    private int adjustIndex(int index, int size) {
        return index >= size ? 0 : index;
    }

    private void removeDeadCreature(List<Creature> armyList, Creature deadCreature) {
        int deadCreatureIndex = armyList.indexOf(deadCreature);
        if (deadCreatureIndex >= 0) {
            armyList.remove(deadCreatureIndex);
        }
    }

    private Optional<Creature> performAttack(Hero attackerHero, Hero defenderHero, Creature attackerCreature) {
        Optional<Creature> optionalDefenderCreature = defenderHero.getWeakestCreature();

        if (optionalDefenderCreature.isEmpty()) {
            return Optional.empty();
        }

        Creature defenderCreature = optionalDefenderCreature.get();
        System.out.println(attackerHero.getName() + ": " + attackerCreature.getName() + " attacks " + defenderCreature.getName());

        int defenderCreatureCount = defenderHero.getArmy().get(defenderCreature);
        int killedCreatureCount = attack(attackerCreature, defenderCreature);
        boolean isDefenderCreatureDead = killedCreatureCount >= defenderCreatureCount;

        killedCreatureCount = Math.min(killedCreatureCount, defenderCreatureCount);
        System.out.println(attackerHero.getName() + ": " + attackerCreature.getName() + " killed " + killedCreatureCount + " " + defenderCreature.getName());

        defenderHero.removeCreature(defenderCreature, killedCreatureCount);

        return isDefenderCreatureDead ? Optional.of(defenderCreature) : Optional.empty();
    }

    private void declareWinner() {
        if (hero1.isAlive()) {
            System.out.println("Hero 1 Won!");
            System.out.println("Hero 1 has army " + hero1.armyToSting());
        } else if (hero2.isAlive()) {
            System.out.println("Hero 2 Won!");
            System.out.println("Hero 2 has army " + hero2.armyToSting());
        } else {
            System.out.println("It's a draw!");
        }
    }

    private int attack(Creature attackerCreature, Creature defenderCreature) {
        return (int) Math.floor(((float) attackerCreature.getDamage()) / ((float) defenderCreature.getDefense()));
    }
}
