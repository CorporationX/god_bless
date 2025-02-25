package school.faang.extremelypoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final String[] CHORES = {"помыть посуду", "подмести пол", "приготовить ужин"};

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String chore : CHORES) {
            executor.submit(new Chore(chore));
        }

        executor.shutdown();

        if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Не все задачи завершились вовремя. Принудительная остановка...");
            executor.shutdownNow();
        }

        System.out.println("Все задачи завершены.");
    }
}
