package school.faang.sprint_3.bjs2_36880_weasleyFamily;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<String> chores = List.of("Помыть посуду", "Пропылесосить", "Приготовить обед", "Покормить кота",
                "Сходить в магазин", "Помойся");
        ExecutorService executor = Executors.newCachedThreadPool();

        chores.forEach(chore -> executor.execute(new Chore(chore)));
        executor.shutdown();

        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                System.out.println("Все сломалось!");
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
