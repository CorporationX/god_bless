package school.faang.task_48417;

import lombok.Getter;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
public class WeasleyFamily {
    private List<String> chores = List.of("Помыть посуду", "Подмести пол",
            "Протереть пыль", "Помыть пол", "Выкинуть мусор");
    ExecutorService executor = Executors.newCachedThreadPool();

    public void startedChores(List<String> choresFamily) {
        for (String task : choresFamily) {
            Chore chore = new Chore(task);
            executor.execute(chore);
        }
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
