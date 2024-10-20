package school.faang.might.magic.distributed;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Army {
    private List<Unit> army = new ArrayList<>();
    private ArmyThread[] threads = new ArmyThread[4];

    public void addUnit(Unit unit) {
        army.add(unit);
    }

    private void distributeTask() {
        int groupSize = army.size() / threads.length;
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new ArmyThread(army.subList(i * groupSize, (i+1) * groupSize));
            threads[i].start();
        }
    }

    public int calculateTotalPower() throws InterruptedException {
        distributeTask();
        for (ArmyThread thread : threads) {
            thread.join();
        }
        return Stream.of(threads).mapToInt(ArmyThread::getResult).sum();
    }
}
