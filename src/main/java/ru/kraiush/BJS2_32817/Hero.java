package ru.kraiush.BJS2_32817;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@ToString
@AllArgsConstructor
public class Hero {
    private String name;
    private String fraction;
    private int level;
    private final List<Creature> ARMY = new LinkedList<>();

    public void addCreature(Creature creature, int quantity) {
        for (int i = 0; i < quantity; i++) {
            if (creature instanceof Pikeman) {
                ARMY.add(new Pikeman());
            }
            if (creature instanceof Griffin) {
                ARMY.add(new Griffin());
            }
            if (creature instanceof Swordman) {
                ARMY.add(new Swordman());
            }
            if (creature instanceof Angel) {
                ARMY.add(new Angel());
            }
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        if (!ARMY.isEmpty()) {
            Iterator<Creature> iterator = ARMY.iterator();
            while (iterator.hasNext() && quantity > 0) {
                Creature currentCreature = iterator.next();
                if (currentCreature.getClass().equals(creature.getClass())) {
                    iterator.remove();
                    quantity--;
                }
            }
        }
    }

    public List<Creature> getArmy() {
        return ARMY;
    }
}
