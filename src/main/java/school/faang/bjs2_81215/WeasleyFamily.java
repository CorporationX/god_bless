package school.faang.bjs2_81215;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final int MAX_WAIT_MINUTES = 1;

    private final String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин"};

    public void doChores() {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String choreName : chores) {
            Chore chore = new Chore(choreName);
            executor.submit(chore);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(MAX_WAIT_MINUTES, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи завершены за " + MAX_WAIT_MINUTES
                                   + " минут. Завершаем принудительно...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.err.println("Ожидание завершения потоков прервано.");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        WeasleyFamily family = new WeasleyFamily();
        family.doChores();
    }
}
