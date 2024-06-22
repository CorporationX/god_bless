package faang.school.godbless.thread3;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> army = new ArrayList<>();

    public int calculateTotalPower() throws InterruptedException {
        List<ThreadCount> threadCounts = new ArrayList<>();
        army.forEach(unit -> startAndAddThreads(unit, threadCounts));
        for (Thread thread : threadCounts) {
            thread.join();
        }
        return threadCounts.stream().mapToInt(ThreadCount::getCount).sum();
    }

    private static void startAndAddThreads(Unit unit, List<ThreadCount> threadCounts) {
        ThreadCount thread = new ThreadCount(unit.getPower());
        thread.start();
        threadCounts.add(thread);
    }

    public void addUnit(Unit unit) {
        army.add(unit);
    }
}
