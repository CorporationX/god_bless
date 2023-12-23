package faang.school.godbless.multithreading.parallelism.heroesArmy;

import lombok.Getter;

public class CreatureThread extends Thread {
    private final Creature creature;
    @Getter
    private int power;

    public CreatureThread(Creature creature) {
        this.creature = creature;
    }

    @Override
    public void run() {
        power = creature.getPower();
    }
}
