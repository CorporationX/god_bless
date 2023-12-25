package faang.school.godbless.multi_paral.task5very_nice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String[] chores = new String[100];

        for (int i = 0; i < 100; i++) {
            chores[i] = "Задача " + (i + 1) ;
        }

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String chore: chores) {
            executorService.submit(new Chore(chore));
        }

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.MINUTES);
    }
}
