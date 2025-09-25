package school.faang.bjs2_89880;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<String> chores = List.of("помыть посуду", "подмести пол", "приготовить ужин");
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : chores) {
            Chore task = new Chore(chore);
            executor.submit(task);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                System.out.println("Выполнение дел затянулось, завершаем.");
                executor.shutdownNow();
            }
            System.out.println("Все дела выполнены.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
