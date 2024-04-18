package faang.school.godbless.BJS2_5739;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Помыть посуду", "Постирать белье", "Погладить рубашки", "Вымыть полы", "Приготовить ужин"};

        ExecutorService cachedPool = Executors.newCachedThreadPool();

        for (String chore : chores) {
            cachedPool.execute(new Chore(chore));
        }
        cachedPool.shutdown();
        try {
            if (!cachedPool.awaitTermination(3500, TimeUnit.MILLISECONDS)) {
                cachedPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            cachedPool.shutdownNow();
        }
        System.out.println("Все задачи выполнены");
    }
}
