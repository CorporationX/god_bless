package faang.school.godbless.heroes_2;

import java.util.ArrayList;
import java.util.List;

public class Army {
    List<Creature> army = new ArrayList<>();

    public int calculateTotalPower() {
        List<CreatureThread> threads = new ArrayList<>();

        for (Creature creature : army) {
            CreatureThread thread = new CreatureThread(creature);
            threads.add(thread);
            thread.start();
        }

        int totalPower = 0;
        for (CreatureThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            totalPower += thread.getPower();
        }

        return totalPower;
    }

    public void addCreature(Creature creature){
        army.add(creature);
    }
}
