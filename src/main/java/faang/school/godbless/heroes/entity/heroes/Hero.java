package faang.school.godbless.heroes.entity.heroes;

import faang.school.godbless.heroes.entity.creatures.Creature;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Hero {
    private String name;
    private String faction;
    private int experience;
    private int level;
    private List<Creature> army;

    public void addCreature(Creature creature, int quantity) {
        if (!army.contains(creature)) {
            army.add(creature);
        }

        int newQuantity = creature.getQuantity() + quantity;
        creature.setQuantity(newQuantity);
    }

    public void removeCreature(Creature creature, int quantity) {
        int newQuantity = creature.getQuantity() - quantity;

        if (newQuantity > 0) {
            creature.setQuantity(newQuantity);
        } else {
            army.remove(creature);
        }
    }

    public void showArmy() {
        System.out.println("Hero " + getName() + " army:");
        army.forEach((creature) -> System.out.println(creature.getClass().getSimpleName() +
                " named " + creature.getName() + " in quantity of " + creature.getQuantity() + " units."));
        System.out.println();
    }
}
