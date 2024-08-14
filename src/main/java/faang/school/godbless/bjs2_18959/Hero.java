package faang.school.godbless.bjs2_18959;

import faang.school.godbless.bjs2_18959.creatures.Creature;

import java.util.List;

public class Hero {
    private String name;
    private List<Creature> army;

    public Hero(String name, List<Creature> army) {
        this.name = name;
        this.army = army;
    }

    public boolean isAlive() {
        return !isDead();
    }

    public boolean isDead() {
        return army.isEmpty();
    }

    public List<Creature> getArmy() {
        return army;
    }

    public void removeIfDead(Creature creature) {
        if (creature.isDead()) {
            army.remove(creature);
        }
    }
}
