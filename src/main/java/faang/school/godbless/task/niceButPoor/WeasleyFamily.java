package faang.school.godbless.task.niceButPoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        Chore[] chores = new Chore[5];

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < chores.length; i++) {
            chores[i] = new Chore(String.valueOf(i));
            executorService.execute(chores[i]);
        }

        executorService.shutdown();
    }
}
