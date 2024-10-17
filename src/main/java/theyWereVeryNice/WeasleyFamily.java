package theyWereVeryNice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final List<Chore> CHORES_LIST = new ArrayList<>(List.of(
            new Chore("помыть посуду"),
            new Chore("подмести пол"),
            new Chore("приготовить ужин")
    ));

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (Chore chore : CHORES_LIST) {
            executor.submit(chore);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                System.out.println("Задачи не завершились за 30 секунд, принудительно останавливаем");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
