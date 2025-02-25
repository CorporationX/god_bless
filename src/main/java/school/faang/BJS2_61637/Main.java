package school.faang.BJS2_61637;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int NUM_THREADS = 4;
    private static final int NUM_VIDEOS = 20;
    private static final int TIME_END = 30;

    public static void main(String[] args) {
        VideoManager vm = new VideoManager();

        ExecutorService es = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            for (int j = 1; j <= NUM_THREADS; j++) {
                int index = i;
                es.submit(() -> vm.addView("Video" + index));
            }
        }

        es.shutdown();
        try {
            if (!es.awaitTermination(TIME_END, TimeUnit.SECONDS)) {
                System.out.println("Завершаем невыполненные задачи...");
                es.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            es.shutdownNow();
        }

        System.out.println(vm.getViewCount("Video3"));
        System.out.println(vm.getViewsMap());
    }
}
