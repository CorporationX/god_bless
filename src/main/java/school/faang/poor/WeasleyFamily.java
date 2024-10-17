package school.faang.poor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {

    public static void main(String[] args) {
        List<String> chores = Arrays.asList("помыть посуду", "подмести пол", "приготовить ужин");
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String choreName : chores) {
            Chore chore = new Chore(choreName);
            executor.execute(chore);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Emergency termination of the program");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
