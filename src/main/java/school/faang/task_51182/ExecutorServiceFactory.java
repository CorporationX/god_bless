package school.faang.task_51182;

import lombok.Getter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceFactory {
    private static final int NUM_THREADS = 10;
    @Getter
    private static final ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

}