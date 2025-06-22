package school.faang.bjs2_81231;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    }
}