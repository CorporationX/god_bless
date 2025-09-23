package school.faang.m3_1_parallelism.weasleyfamily;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores =  {"помыть посуду", "подмести пол", "приготовить ужин"};
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (String choreName : chores) {
            executorService.submit(new Chore(choreName));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
