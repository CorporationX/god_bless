package faang.school.godbless.gameHeroesOfMight;

import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

@Data
public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    private Set<Creature> ownArmy = new HashSet<>();


    public void addCreature(@NonNull Creature creature, int quantity) {
        if (!ownArmy.contains(creature)) {
            ownArmy.add(creature);
        }
        int total_quantity = creature.getAmount() + quantity;
        creature.setAmount(total_quantity);
    }

    public void removeCreature(Creature creature, int quantity) {
        if (!ownArmy.contains(creature)) {
            throw new TheseTypesOfTroopsNotAvailableException("Этих видов войск нет в запасе");
        }
        int total_quantity = creature.getAmount() - quantity;
        if (total_quantity <= 0) {
            ownArmy.remove(creature);

        } else {
            creature.setAmount(total_quantity);
        }


    }

    public int totalArmyDamage() {
        int totalArmyDamage = 0;

        for (Creature creature : ownArmy) {
            totalArmyDamage += creature.getDamage();
        }
        return totalArmyDamage;
    }

    public static Creature getRandomCreatureFromArmy(Set<Creature> ownArmy) {
        int size = ownArmy.size();
        if (size == 0) {
            throw new NoSuchElementException("Army is empty");
        }
        int randomIndex = new Random().nextInt(size);
        return new ArrayList<>(ownArmy).get(randomIndex);
    }
}
