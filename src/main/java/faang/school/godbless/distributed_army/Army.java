package faang.school.godbless.distributed_army;

import faang.school.godbless.distributed_army.creature.Creature;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Creature> army;
    private volatile int totalPower;

    public Army() {
        this.army = new ArrayList<>();
    }

    public void addUnit(Creature creature) {
        army.add(creature);
    }

    public int calculateTotalPower() {
        List<Thread> threads = new ArrayList<>(army.size());
        army.forEach(creature -> {
            Thread thread = new Thread(() -> addPower(creature.getPower()));
            threads.add(thread);
            thread.start();
        });
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        return totalPower;
    }

    private synchronized void addPower(int power) {
        System.out.printf("Total power: %s. +%s power\n", totalPower, power);
        System.out.println(Thread.currentThread().getName());
        totalPower += power;
    }
}
