package school.faang.bjs2_89663;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public record WeasleyFamily(List<String> chores) {
    public static final String[] CHORES = {"помыть посуду", "подмести пол", "приготовить ужин"};

    public void startHomework() {
        ExecutorService executor = Executors.newCachedThreadPool();
        System.out.println("Семья Уизли начинает уборку!");
        for (String task : chores) {
            Chore chore = new Chore(task);
            executor.execute(chore);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
        System.out.println("Задачи выполнены!");
    }
}