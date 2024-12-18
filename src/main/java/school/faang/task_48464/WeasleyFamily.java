package school.faang.task_48464;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class WeasleyFamily {
    List<Chore> chores = Arrays.asList(new Chore("wash the dishes"), new Chore("cook dinner"),
            new Chore("sweep the floor"));

    public void doAllWork() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        ExecutorService executor = Executors.newCachedThreadPool();
        for (Chore chore : chores) {
            executor.submit(chore);
            System.out.println(String.format("Submit: %s", chore.getChore()));
        }
        executor.shutdown();
        System.out.println("All task's submit ");

        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}
