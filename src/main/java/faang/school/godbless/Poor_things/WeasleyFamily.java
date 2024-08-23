package faang.school.godbless.Poor_things;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Do the cooking", "Wash dishes", "Do the gardening", "Fix the pipes", "Clean closet"};
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < chores.length; i++) {
            Chore chore = new Chore(chores[i]);
            executor.execute(chore);
            System.out.println(chores[i] + " is done");
        }
        executor.shutdown();
        try {
            if (executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}