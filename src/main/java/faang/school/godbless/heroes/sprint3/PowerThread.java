package faang.school.godbless.heroes.sprint3;

import faang.school.godbless.heroes.sprint3.creature.Creature;
import lombok.Getter;

@Getter
public class PowerThread extends Thread {
    private final Creature creature;
    private long power;

    public PowerThread(Creature creature) {
        this.creature = creature;
    }

    @Override
    public void run() {
        power = (long) creature.getPower() * creature.getQuantity();
    }
}
