package faang.school.godbless.theywereverynice;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {

    public static void main(String[] args) {
        String[] chores = {"Planning", "To do the homework", "To do the housework"};

        ExecutorService executor = Executors.newCachedThreadPool();
        for (String chore : chores) {
            executor.execute(new Chore(chore));
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                log.error("Not all chores have been fulfilled");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All chores have been fulfilled");
    }
}
