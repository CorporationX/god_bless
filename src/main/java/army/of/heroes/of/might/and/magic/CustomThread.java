package army.of.heroes.of.might.and.magic;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class CustomThread extends Thread {
    private AtomicInteger totalPower;
    private final Creature creature;

    CustomThread(Creature creature) {
        this.creature = creature;
    }

    @Override
    public void run() {
        this.totalPower = new AtomicInteger(this.creature.getPower());
    }
}
