package bjs289597;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"wash the dishes", "sweep the floor", "cook dinner", "do the laundry", "water the plants"};
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String task : chores) {
            executorService.submit(new Chore(task));
        }
        executorService.shutdown();
    }
}
