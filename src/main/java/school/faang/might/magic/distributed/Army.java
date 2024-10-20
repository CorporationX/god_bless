package school.faang.might.magic.distributed;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Army {
    private List<Unit> army = new ArrayList<>();
    private List<ArmyThread> threads;

    public void addUnit(Unit unit) {
        army.add(unit);
    }

    private void distributeTask() {
        int numberOfThreads = Math.min(army.size(), 4);
        threads = new ArrayList<>(numberOfThreads);
        int groupSize = (int) Math.ceil((double) army.size() / numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * groupSize;
            int end = Math.min(start + groupSize, army.size());
            if (start < army.size()) {
                threads.add(new ArmyThread(army.subList(start, end)));
                threads.get(i).start();
            }
        }
    }

    public int calculateTotalPower() throws InterruptedException {
        distributeTask();
        for (ArmyThread thread : threads) {
            thread.join();
        }
        return threads.stream().mapToInt(ArmyThread::getResult).sum();
    }
}
