package faang.school.godbless.parallel.extremely_poor_BC_3247.extremely_poor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = new String[]{"task1", "task2", "task3", "task4", "task5", "task6", "task7"};
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < chores.length; i++) {
            Chore chore = new Chore(chores[i]);
            executor.execute(chore);
        }
        executor.shutdown();
    }
}
