package faang.school.godbless.multithreading_async.task_9;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    private static final int THREAD_COUNT = 4;
    private static final int N = 1000;

    public static void main(String[] args) {
        PiCalculator piCalculator = new PiCalculator();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        log.info("PI : {}", piCalculator.calculatePi(N, executor));
        executor.shutdown();
    }
}
