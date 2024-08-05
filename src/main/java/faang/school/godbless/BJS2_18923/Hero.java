package faang.school.godbless.BJS2_18923;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Hero {
    private final int MAX_ARMY_SIZE = 7;
    private String name;
    private String fraction;
    private int experience;
    private int level;

    @Setter
    private boolean isDefeated = false;
    private List<Creature> army = new ArrayList<>(MAX_ARMY_SIZE);

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }

    public void addCreature(Creature creature, int quantity) {
        if (army.size() >= MAX_ARMY_SIZE) {
            throw new IllegalStateException("Too many creatures in hero");
        }
        creature.setQuantity(quantity);
        army.add(creature);
    }

    public void removeCreature(Creature creature, int quantity) {
//
    }

}
