package faang.school.godbless.heroesOfMandM;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    @Setter
    private Map<Creature, Integer> army;

    public Hero(String name) {
        army = new HashMap<>();
        this.name = name;
    }

    void addCreature(Creature creature, int quantity) {
        if (quantity > 0) {
            army.putIfAbsent(creature, 0);
            army.put(creature, army.get(creature) + quantity);
        }
    }

    void removeCreature(Creature creature, int quantity) {
        if (quantity > 0) {
            army.put(creature, army.get(creature) - quantity);
            if (army.get(creature) <= 0) {
                army.remove(creature);
            }
        }
    }

    List<Creature> getArmyByItem() {
        List<Creature> armyByItem = new ArrayList<>();
        if (army.isEmpty()) {
            return null;
        }
        for (Map.Entry<Creature, Integer> creature : army.entrySet()) {
            for (int i = 0; i < creature.getValue(); i++) {
                armyByItem.add(creature.getKey());
            }
        }
        return armyByItem;
    }

    public void attack(Hero secondHero) {
        Creature creatureFirstHero = getArmyItem(army);
        Creature creatureSecondHero = getArmyItem(secondHero.getArmy());
        creatureSecondHero.getDamageFrom(creatureFirstHero);
        updateArmy(secondHero);
    }

    private Creature getArmyItem(Map<Creature, Integer> army) {
        for (Map.Entry<Creature, Integer> creature : army.entrySet()) {
            return creature.getKey();
        }
        return null;
    }

    private void updateArmy(Hero secondHero) {
        Map<Creature, Integer> secondHeroArmy = secondHero.getArmy();
        List<Creature> deathList = new ArrayList<>();
        for (Map.Entry<Creature, Integer> creature : secondHeroArmy.entrySet()) {
            if (creature.getKey().isDeath()) {
                deathList.add(creature.getKey());
            }
        }
        for (Creature creature : deathList) {
            secondHero.getArmy().remove(creature);
        }
    }
}
