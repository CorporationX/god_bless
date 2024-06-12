package faang.school.godbless.Task10;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor

public class Hero {

    private static int MAX_CAPACITY = 5;
    private String name;
    private String fraction;
    private int exp;
    private int level;
    private List<Creature> army;

    {
        army = new ArrayList<>(MAX_CAPACITY);
    }

    public void addToArmy(Creature creature, int quantity) {
        if (army.size() + quantity <= MAX_CAPACITY) {
            for (int i = 0; i < quantity; i++) {
                army.add(creature);
            }
        } else {
            throw new IllegalArgumentException("hero " + name + " has no slots");
        }
    }

    public void removeCreatures(Creature creature, int quantity) {
        if (!army.contains(creature)) {
            System.out.println("no such creatures in army");
        } else {
            int count = 0;
            for (Creature unit : army) {
                if (unit == creature);
                count = count + 1;
            }
            if (count<quantity) System.out.println("invalid quantity");
            else {
                for (Creature unit : army) {
                    if (unit==creature) {
                        army.remove(unit);
                        quantity = quantity - 1;
                        if (quantity==0) break;
                    }
                }
            }
        }
    }

}
