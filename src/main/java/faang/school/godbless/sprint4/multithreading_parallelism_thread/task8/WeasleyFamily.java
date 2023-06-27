package faang.school.godbless.sprint4.multithreading_parallelism_thread.task8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {

    public static void main(String[] args) {
        String[] chores = {"wash the dishes", "work on homework", "play video games", "read books"};
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executor.submit(new Chore(chore));
        }

        executor.shutdown();
    }
}
