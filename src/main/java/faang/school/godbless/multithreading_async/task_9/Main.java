package faang.school.godbless.multithreading_async.task_9;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;

@Slf4j
public class Main {
    private static final int N = 100;

    public static void main(String[] args) {
        PiCalculator piCalculator = new PiCalculator(Executors.newFixedThreadPool(N));
        log.info("PI : {}", piCalculator.calculatePi(N));
        piCalculator.shutdownExecutor();
    }
}
