package faang.school.godbless.BJS25689;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Помыть посуду", "Погладить одежду", "Полить цветы", "Приготовить ужин"};

        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : chores) {
            Runnable task = new Chore(chore);
            executor.execute(task);
        }

        executor.shutdown();
    }
}
