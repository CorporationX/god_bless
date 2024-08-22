package faang.school.godbless.BJS224036;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Помыть посуду", "Постирать белье", "Погладить рубашки", "Вымыть полы", "Приготовить ужин"};
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : chores) {
            Chore task = new Chore(chore);
            executor.execute(task);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Принудительное завершение");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.err.println("Завершение прервано");
            executor.shutdownNow();
        }

        System.out.println("All chores have been completed.");
    }
}
