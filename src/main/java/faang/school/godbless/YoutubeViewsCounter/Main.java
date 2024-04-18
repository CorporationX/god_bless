package faang.school.godbless.YoutubeViewsCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) throws InterruptedException {
        List<String> ids = getVideoIds();
        VideoManager manager = new VideoManager();
        ids.forEach(manager::addVideo);

        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 1; i <= NUM_VIDEOS; i++) {
            final String id = "ID-" + i;
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                pool.execute(() -> {
                    manager.addView(id);
                    System.out.println("VideoId[" + id + "] -> " + manager.getViewCount(id));
                });
            }
        }
        pool.shutdown();

        while (!pool.awaitTermination(10, TimeUnit.SECONDS)) ;
    }

    private static List<String> getVideoIds() {
        List<String> ids = new ArrayList<>();
        for (int i = 1; i <= NUM_VIDEOS; i++) {
            ids.add("ID-" + i);
        }
        return ids;
    }
}
