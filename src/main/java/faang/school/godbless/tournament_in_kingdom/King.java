package faang.school.godbless.tournament_in_kingdom;

import lombok.Getter;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
public class King {
    protected static ExecutorService poolThreads = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        Knight firstKnight = new Knight("Клиган");
        firstKnight.addTrial(new Trial(firstKnight, "Доастать со дна реки мешок с цепями"));
        firstKnight.addTrial(new Trial(firstKnight, "Защитить короля от дракона"));

        Knight secondKnight = new Knight("Пёс");
        secondKnight.addTrial(new Trial(secondKnight, "Разрубить пополам лошадь"));
        secondKnight.addTrial(new Trial(secondKnight, "Разрушить дом"));

        List<Knight> knights = List.of(firstKnight, secondKnight);

        int amountKnight = (int) knights.stream()
                .count();

        for (Knight knight : knights) {
            knight.startTrials();
        }

        poolThreads.shutdown();
        try {
            if (!poolThreads.awaitTermination(60, TimeUnit.SECONDS)) {
                poolThreads.shutdownNow();
                if (!poolThreads.awaitTermination(60, TimeUnit.SECONDS)) {
                    System.err.println("Пул потоков не завершился корректно");
                }
            }
        } catch (InterruptedException e) {
            poolThreads.shutdownNow();
            Thread.currentThread().interrupt();
        }

    }
}
