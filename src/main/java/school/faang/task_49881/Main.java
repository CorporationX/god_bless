package school.faang.task_49881;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Point point = new Point();

        int number = 1_000_000;
        double pi = point.calculatePi(number, executorService);
        System.out.println("pi: " + pi);

        if (!executorService.awaitTermination(20, TimeUnit.SECONDS)) {
            executorService.shutdown();
        }
    }
}