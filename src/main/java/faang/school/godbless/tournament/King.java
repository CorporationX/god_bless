package faang.school.godbless.tournament;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class King {

    public static void main(String[] args) {
        List<Knight> knights = getKnights();
        knights.forEach(Knight::startTrials);
        knights.forEach(King::shutdownAndAwaitExecutors);
    }

    private static List<Knight> getKnights() {
        List<Knight> knights = List.of(new Knight("Leon"), new Knight("Scott"));
        for (int i = 0; i < knights.size(); i++) {
            Knight knight = knights.get(i);
            knight.addTrial(new Trial(knight, "Trial " + (2 * i + 1)));
            knight.addTrial(new Trial(knight, "Trial " + (2 * i + 2)));
        }
        return knights;
    }

    private static void shutdownAndAwaitExecutors(Knight knight) {
        knight.getExecutor().shutdown();
        awaitTermination(knight.getExecutor(), 5L);
    }

    private static void awaitTermination(ExecutorService executorService, Long minutes) {
        try {
            executorService.awaitTermination(minutes, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}