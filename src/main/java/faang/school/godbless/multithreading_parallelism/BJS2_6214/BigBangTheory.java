package faang.school.godbless.multithreading_parallelism.BJS2_6214;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Task sheldonTask = new Task("Sheldon", "Prepare theory");
        Task leonardTask = new Task("Leonard", "Model experiment");
        Task howardTask = new Task("Howard", "Tool development");
        Task rajeshTask = new Task("Rajesh", "Data analyze");

        executorService.execute(sheldonTask);
        executorService.execute(leonardTask);
        executorService.execute(howardTask);
        executorService.execute(rajeshTask);

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                log.error("Time out end for this task");
                return;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All tasks were finished!");
    }
}
