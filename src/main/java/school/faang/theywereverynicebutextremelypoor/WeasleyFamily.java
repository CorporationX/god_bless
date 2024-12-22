package school.faang.theywereverynicebutextremelypoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {

    public static void main(String[] args) {
        String[] chores = {"помыть посуду",
                "подмести пол",
                "приготовить ужин",
                "погладить вещи",
                "вынести мусор"
        };

        ExecutorService executor = Executors.newCachedThreadPool();

        for (String task : chores) {
            Chore chore = new Chore(task);
            executor.execute(chore);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Задачи не выполнились за 5 минут, принудительно останавливаем...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
