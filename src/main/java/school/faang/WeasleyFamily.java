package school.faang;

import lombok.AllArgsConstructor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class WeasleyFamily {
    private final String[] chores;


    public static void main(String[] args) {
        String[] chores = {"Помыть посуду", "Подмести пол", "Приготовить ужин", "Постирать вещи", "Почитать книгу"};
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String task : chores) {
            Chore chore = new Chore(task);
            executor.execute(chore);
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
