package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Optional;


@AllArgsConstructor
@Data
public class Hero {
    private String name;
    private String fraction;
    private int expirience;
    private int level;
    private HashMap<Creature, Integer> army;

    public void addCreature(Creature creature, int quantity) {
        if (army.containsKey(creature)) {
            army.merge(creature, quantity, Integer::sum);
        } else {
            army.put(creature, quantity);
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        if (!army.containsKey(creature)) {
            System.out.println("There is not type of " + creature.getName() + " in the army");
        } else {
            if (army.get(creature) < quantity) {
                System.out.println("Quantity " + creature.getName() + " " + "less than the quantity being deleted");
            } else {
                army.merge(creature, -quantity, Integer::sum);
            }
        }
    }

    public void printArmy() {
        for (var soldier : army.entrySet()) {
            System.out.println(soldier.getKey().getName() + ": " + soldier.getValue());
        }
    }

    public int totalArmyDefense() {
        Optional<Integer> defense = getArmy().entrySet().stream().map(x -> x.getKey().getDefend() * x.getValue()).reduce(Integer::sum);
        return defense.orElse(0);
    }

    public int totalArmyAttack() {
        Optional<Integer> attack = getArmy().entrySet().stream().map(x -> x.getKey().getDamage() * x.getValue()).reduce(Integer::sum);
        return attack.orElse(0);
    }
}
