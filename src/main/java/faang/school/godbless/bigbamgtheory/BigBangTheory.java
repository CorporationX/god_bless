package faang.school.godbless.bigbamgtheory;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BigBangTheory {

    private static final int amountThreads = 4;
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(amountThreads);
        Task task1 = new Task("algebra", 1);
        Task task2 = new Task("programming", 1);
        Task task3 = new Task("english", 1);
        Task task4 = new Task("geometry", 1);

        executor.execute(task1);
        executor.execute(task2);
        executor.execute(task3);
        executor.execute(task4);

        executor.shutdown();

        try {
            if(!executor.awaitTermination(1, TimeUnit.MINUTES)){
                log.error("Not all tasks were completed");
            }
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }

        System.out.println("All tasks were completed");
    }
}
