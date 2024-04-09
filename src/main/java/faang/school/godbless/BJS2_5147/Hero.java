package faang.school.godbless.BJS2_5147;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    private final Set<Creature> creatures = new HashSet<>();

    public void addCreature(Creature creature, int quantity) {
        creature.setQuantity(quantity);
        creatures.add(creature);
    }

    public void removeCreature(Creature creature, int quantity) {
        for (Creature creatureFromArmy : creatures) {
            if (creatureFromArmy.getName().equals(creature.getName())) {
                int newQuantity = creatureFromArmy.getQuantity() - quantity;
                creatures.remove(creatureFromArmy);
                creatureFromArmy.setQuantity(newQuantity);
                creatures.add(creatureFromArmy);
            }
        }
    }

    public void getArmy() {
        for (Creature creature : creatures) {
            System.out.println(creature.toString());
        }
    }
}
