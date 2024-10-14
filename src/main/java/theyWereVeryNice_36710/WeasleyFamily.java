package theyWereVeryNice_36710;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final List<String> CHORES = Arrays.asList("помыть посуду", "подмести пол", "приготовить ужин");

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : CHORES) {
            executor.execute(new Chore(chore));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Ёще не все задания выполнены");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
