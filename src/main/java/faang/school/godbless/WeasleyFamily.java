package faang.school.godbless;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) throws InterruptedException {
        var chores = Arrays.asList(
                new Chore("Washing dishes"),
                new Chore("Cleaning the house"),
                new Chore("Doing laundry"),
                new Chore("Mowing the lawn")
        );
        ExecutorService executor = Executors.newCachedThreadPool();
        chores.forEach(executor::submit);
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Done");
    }
}
