package faang.school.godbless.Multithreading.ParallelismAndThread.task08_TheyWereVeryNiceButExtremelyPoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Помыть посуду", "Постирать белье", "Погладить рубашки", "Вымыть полы", "Приготовить ужин"};
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < chores.length; i++) {
            Chore chore = new Chore(chores[i]);
            executorService.execute(chore);
        }
        executorService.shutdown();
    }
}
