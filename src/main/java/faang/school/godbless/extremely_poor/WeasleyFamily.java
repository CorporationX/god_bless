package faang.school.godbless.extremely_poor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"A", "B", "C", "D", "E"};
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String chore : chores) {
            Chore task = new Chore(chore);
            executor.submit(task);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
    }
}
