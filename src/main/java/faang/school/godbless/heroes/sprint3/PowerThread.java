package faang.school.godbless.heroes.sprint3;

import faang.school.godbless.heroes.sprint3.creature.Creature;
import lombok.Getter;

import java.util.List;

@Getter
public class PowerThread extends Thread {
    private final List<Creature> creatures;
    private long power;

    public PowerThread(List<Creature> creatures) {
        this.creatures = creatures;
    }

    @Override
    public void run() {
        power = creatures.stream().mapToLong(Creature::getPower).sum();
    }
}
