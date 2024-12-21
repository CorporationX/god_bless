package school.faang.task_48899;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {

    public static void main(String[] args) {
        String[] choreNames = new String[] {"помыть посуду", "подмести пол", "приготовить ужин"};
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String name : choreNames) {
            executor.execute(new Chore(name));
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(20, TimeUnit.SECONDS)) {
                System.out.println("Задачи не завершились за 20 секунд, принудительно останавливаем...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
