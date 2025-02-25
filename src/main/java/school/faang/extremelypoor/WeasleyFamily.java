package school.faang.extremelypoor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final String[] CHORES = {"помыть посуду", "подмести пол", "приготовить ужин"};

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<?>> futures = new ArrayList<>();

        for (String chore : CHORES) {
            futures.add(executor.submit(new Chore(chore)));
        }

        executor.shutdown();

        try {
            for (Future<?> future : futures) {
                future.get();
            }

            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Не все задачи завершились вовремя. Принудительная остановка...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Ожидание завершения задач было прервано: " + e.getMessage());
        } catch (ExecutionException e) {
            System.err.println("Ошибка выполнения задачи: " + e.getMessage());
        }

        System.out.println("Все задачи завершены.");
    }
}
