package school.faang.bjs2_72951;

import lombok.Data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Data
public class WeasleyFamily {

    private final String[] chores;

    public void doChores() {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executor.execute(new Chore(chore));
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Задачи не завершились за 5 минут, принудительно останавливаем...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
