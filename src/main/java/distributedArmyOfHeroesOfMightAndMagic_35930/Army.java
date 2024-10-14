package distributedArmyOfHeroesOfMightAndMagic_35930;

import distributedArmyOfHeroesOfMightAndMagic_35930.entity.Archer;
import distributedArmyOfHeroesOfMightAndMagic_35930.entity.Creature;
import distributedArmyOfHeroesOfMightAndMagic_35930.entity.Mage;
import distributedArmyOfHeroesOfMightAndMagic_35930.entity.Swordsman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Army {
    private int power = 0;
    private final List<Creature> creatures;
    private final Map<String, List<Creature>> indexCreatures;

    public Army() {
        creatures = new ArrayList<>();
        indexCreatures = new HashMap<>();
    }

    public void addUnit(Creature creature) {
        creatures.add(creature);
        indexCreatures.computeIfAbsent(creature.getClass().getName(), k -> new ArrayList<>()).add(creature);
    }

    public int calculateTotalPower() throws InterruptedException {
        for (Creature creature : creatures) {
            Thread thread = new Thread(() -> calculatePower(creature));
            thread.start();
            thread.join();
        }
        return power;
    }

    private void calculatePower(Creature creature) {
        power += creature.getPower();
    }

}
