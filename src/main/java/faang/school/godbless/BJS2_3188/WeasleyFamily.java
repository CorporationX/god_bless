package faang.school.godbless.BJS2_3188;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) throws InterruptedException {
        // Дела по дому, которые нужно сделать
        String[] chores = {"Помыть посуду", "Постирать белье", "Погладить рубашки", "Вымыть полы", "Приготовить ужин"};
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (var chore : chores) {
            executorService.execute(new Chore(chore));
        }
        executorService.shutdown();
        boolean terminationResult = executorService.awaitTermination(60, TimeUnit.SECONDS);
        executorService.shutdownNow();
        if (terminationResult) {
            System.out.println("All task done!");
        } else {
            System.out.println("Not all tasks have been completed!");
        }
    }

}
