package faang.school.godbless.extremely_poor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {

    private static final int CHORE_COUNT = 5;

    public static void main(String[] args) {
        Chore[] chores = new Chore[CHORE_COUNT];

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < chores.length; i++) {
            chores[i] = new Chore("chore" + i);
            executor.execute(chores[i]);
        }

        executor.shutdown();

        try {
            executor.awaitTermination(3, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
