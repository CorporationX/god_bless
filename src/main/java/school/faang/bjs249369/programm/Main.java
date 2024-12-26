package school.faang.bjs249369.programm;

import school.faang.bjs249369.menager.VideoManager;
import school.faang.bjs249369.util.Constants;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        VideoManager manager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(Constants.NUM_THREADS);
        for (int i = 0; i < Constants.NUM_VIDEOS; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < Math.random() * 500; j++) {
                    executorService.submit(() -> manager.addView((int) (Math.random() * Constants.NUM_VIDEOS)));
                }
            });
            int finalI = i;
            executorService.submit(() -> System.out.println("Song :" + finalI + " cnt "
                    + manager.getViewCount(finalI)));
        }
        executorService.shutdown();
        try {
            System.out.println(executorService.awaitTermination(100, TimeUnit.SECONDS));
            System.out.println(manager);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
