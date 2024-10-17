package school.faang.godbless.bjs2_35878;

import school.faang.godbless.bjs2_35878.units.Fighter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Army {
    private final List<Fighter> fighters = new ArrayList<>();

    public void addUnit(Fighter unit) {
        fighters.add(unit);
    }

    public int calculateTotalPower() {
        return fighters.stream()
                .map(fighter -> {
                    CountArmyPowerThread thread = new CountArmyPowerThread();
                    thread.addUnit(fighter);
                    thread.start();
                    return thread;
                }).toList().stream().mapToInt(thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        throw new IllegalStateException("Interrupted when join thread");
                    }
                    return thread.getPower();
                }).sum();
    }

    public int calculateTotalPower(int numOfThreads) {
        int batchSize = fighters.size() / numOfThreads;
        List<CountArmyPowerThread> threads = new ArrayList<>();
        int startIndex = 0;
        while (startIndex != fighters.size() && threads.size() < numOfThreads) {
            CountArmyPowerThread thread = new CountArmyPowerThread();
            int endIndex = threads.size() == numOfThreads - 1 ? fighters.size() : startIndex + batchSize;
            IntStream.range(startIndex, endIndex)
                    .forEach(index -> thread.addUnit(fighters.get(index)));
            thread.start();
            threads.add(thread);
            startIndex = endIndex;
        }
        return threads.stream().mapToInt(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new IllegalStateException("Interrupted when join thread");
            }
            return thread.getPower();
        }).sum();
    }
}
