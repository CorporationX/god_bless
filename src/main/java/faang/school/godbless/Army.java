package faang.school.godbless;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Army {

    private final List<Creature> creatures = new ArrayList<>();

    public void addUnit(Creature creature) {
        creatures.add(creature);
    }

    public int calculateTotalPower() {
        List<ArmyThread> threads = new ArrayList<>();

        for (Creature creature : creatures) {
            ArmyThread thread = new ArmyThread(creature);
            threads.add(thread);
            thread.start();
        }

        int totalPower = 0;

        for (ArmyThread thread : threads) {
            try {
                thread.join();
                totalPower += thread.getTotalPower();
            } catch (InterruptedException e) {
                log.error("An error occurred while calculating total power", e);
            }
        }

        return totalPower;
    }
}
