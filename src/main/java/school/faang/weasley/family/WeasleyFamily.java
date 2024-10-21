package school.faang.weasley.family;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] tasks = {"wash the dishes", "sweep the floor", "cook dinner", "do the laundry", "feed cat"};
        Chore[] chores = new Chore[tasks.length];

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < chores.length; i++) {
            chores[i] = new Chore(tasks[i]);
            executor.submit(chores[i]);
        }

        executor.shutdown();
    }
}
