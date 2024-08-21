package faang.school.godbless.BJS2_23497;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    private static final int THREAD_LIMIT = 2;
    private static List<Knight> knights;

    public static void main(String[] args) {
        generateKnights();
        generateTrials();

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_LIMIT);

        for (Knight knight : knights) {
            knight.startTrials(executorService);
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    public static void generateTrials() {
        for (int i = 0; i < knights.size(); i++) {
            knights.get(i).addTrial(new Trial(knights.get(i).getName(), "Испытание №" + i));
        }
    }

    public static void generateKnights() {
        knights = new ArrayList<>(List.of(
                new Knight("Рыцарь 1"),
                new Knight("Рыцарь 2"),
                new Knight("Рыцарь 3"),
                new Knight("Рыцарь 4"),
                new Knight("Рыцарь 5"),
                new Knight("Рыцарь 6"),
                new Knight("Рыцарь 7"),
                new Knight("Рыцарь 8")
        ));
    }
}
