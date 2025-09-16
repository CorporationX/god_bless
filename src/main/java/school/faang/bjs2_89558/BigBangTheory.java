package school.faang.bjs2_89558;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static school.faang.bjs2_89558.TaskName.dataAnalysis;
import static school.faang.bjs2_89558.TaskName.experimentalDesign;
import static school.faang.bjs2_89558.TaskName.instrumentDevelopment;
import static school.faang.bjs2_89558.TaskName.theoryPreparation;

@Slf4j
public class BigBangTheory {
    public static final int COUNT_POOL_THREAD = 4;
    public static final int TIME_WAITING_THREAD = 5;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(COUNT_POOL_THREAD);

        Task taskSheldon = new Task("Sheldon", theoryPreparation);
        Task taskLeonard = new Task("Leonard", experimentalDesign);
        Task taskHoward = new Task("Howard", instrumentDevelopment);
        Task taskRajesh = new Task("Rajesh", dataAnalysis);

        executor.submit(taskSheldon);
        executor.submit(taskLeonard);
        executor.submit(taskHoward);
        executor.submit(taskRajesh);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIME_WAITING_THREAD, TimeUnit.MINUTES)) {
                executor.shutdownNow();
                log.info("Threads terminated after time expired");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            log.info("Waiting was interrupted - Forced termination", e);
        }
    }
}
