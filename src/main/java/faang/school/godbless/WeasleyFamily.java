package faang.school.godbless;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    // Дела по дому, которые нужно сделать
    public static void main(String[] args) {
    String[] chores = {"Помыть посуду", "Постирать белье", "Погладить рубашки", "Вымыть полы", "Приготовить ужин"};
        ExecutorService executorService =  Executors.newCachedThreadPool();
        Arrays.stream(chores).forEach(chore -> {
            executorService.submit(new Chore(chore));
        });
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(3500, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
        System.out.println("God Bless!");
    }
}