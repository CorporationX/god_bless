package faang.school.godbless.BJS2_24141;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {
                "Помыть посуду",
                "Постирать белье",
                "Погладить рубашки",
                "Вымыть полы",
                "Приготовить ужин"
        };

        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executor.execute(new Chore(chore));
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("Все дела выполнены.");
    }
}
