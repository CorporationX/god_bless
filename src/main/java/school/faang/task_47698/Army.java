package school.faang.task_47698;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Army {
    private final List<Unit> units;

    public Army() {
        this.units = new ArrayList<>();
    }

    public void addUnit(@NonNull Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        final int threadsCount = 3;
        final int batchSize = units.size() / threadsCount;

        final int initialCapacity = threadsCount + 1;
        final List<Thread> threads = new ArrayList<>(initialCapacity);
        final List<PowerCalculator> tasks = new ArrayList<>(initialCapacity);

        Consumer<PowerCalculator> registerAndStart = calculator -> {
            tasks.add(calculator);
            Thread thread = new Thread(calculator);
            threads.add(thread);
            thread.start();
        };

        for (int i = 0; i < threadsCount; i++) {
            int startIndex = i * batchSize;
            int endIndex = startIndex + batchSize;

            registerAndStart.accept(new PowerCalculator(units, startIndex, endIndex));
        }

        final int remainingUnitsCount = units.size() - batchSize * threadsCount;
        if (remainingUnitsCount > 0) {
            int startIndex = batchSize * threadsCount;
            int endIndex = startIndex + remainingUnitsCount;

            registerAndStart.accept(new PowerCalculator(units, startIndex, endIndex));
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return tasks.stream()
                .mapToInt(PowerCalculator::getTotalPower)
                .sum();
    }

}
