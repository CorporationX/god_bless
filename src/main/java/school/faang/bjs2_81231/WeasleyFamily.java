package school.faang.bjs2_81231;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<Chore> chores = List.of(
                new Chore("помыть посуду"),
                new Chore("подмести пол"),
                new Chore("приготовить ужин")
        );

        ExecutorService executor = Executors.newCachedThreadPool();
        for (Chore chore : chores) {
            executor.submit(chore);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Не все задачи завершены");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}