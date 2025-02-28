package school.faang.they_were_very_nice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {

    private static final String[] CHORES = {"помыть посуду", "подмести пол", "приготовить ужин"};

    private static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < CHORES.length; i++) {
            Chore chore = new Chore(CHORES[i]);
            EXECUTOR.submit(chore);
        }
        EXECUTOR.shutdown();
        EXECUTOR.awaitTermination(2, TimeUnit.SECONDS);
    }
}
