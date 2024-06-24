package faang.school.godbless.sprint_3.multithreading_parallelism_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        int length = 100000;
        Chore[] chores = new Chore[length];
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < length; i++) {
            Chore chore = new Chore("task_" + i);
            chores[i] = chore;

            executorService.submit(chore);
        }

        executorService.shutdown();

        while (!executorService.isTerminated());

        System.out.println("Работа завершена.");
    }
}
