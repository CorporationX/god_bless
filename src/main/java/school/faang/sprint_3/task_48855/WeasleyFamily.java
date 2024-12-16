package school.faang.sprint_3.task_48855;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final int TWO_MINUTES = 2;

    public static void main(String[] args) {
        String[] chores = ChoreData.getData();

        ExecutorService executor = Executors.newCachedThreadPool();

        for (String task : chores) {
            Chore chore = new Chore(task);
            executor.submit(chore);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(TWO_MINUTES, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи завершены в отведенное время");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            throw new RuntimeException("Главный поток был прерван: " + e.getMessage());
        }
        System.out.println("Все задачи выполнены!");
    }
}
