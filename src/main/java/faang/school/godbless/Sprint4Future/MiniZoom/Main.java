package faang.school.godbless.Sprint4Future.MiniZoom;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Conference conference = new Conference(5);

        ExecutorService executorService = Executors.newFixedThreadPool(7);

        for (int i = 0; i < 10; i++) {
            executorService.execute(()->{
                new Participant().joinConference();
                try {
                    conference.getCyclicBarrier().await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
