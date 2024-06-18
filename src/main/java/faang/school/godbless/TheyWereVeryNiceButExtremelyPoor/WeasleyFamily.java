package faang.school.godbless.TheyWereVeryNiceButExtremelyPoor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<String> chores = List.of("do the laundry", "wash the dishes", "vacuum the floors", "take out the trash", "clean the bathroom");
        ExecutorService executor = Executors.newCachedThreadPool();
        System.out.println("Start all tasks");
        for (String chore : chores) {
            Chore currentChore = new Chore(chore);
            executor.submit(currentChore);
        }
        try {
            executor.awaitTermination(2, SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
        System.out.println("End all tasks");
    }
}
