package school.faang.task48409;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {

        List<String> chores = Arrays.asList("помыть посуду ", "подмести пол ",
                "приготовить ужин");

        ExecutorService executor = Executors.newCachedThreadPool();


        for (String task : chores) {
            Chore chore = new Chore(task);
            executor.execute(chore);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println(" Задачи не завершились за 5 мин ,"
                        + " принудительно останавливаем");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
