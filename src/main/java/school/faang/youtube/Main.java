package school.faang.youtube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        VideoManager manager = new VideoManager();
        manager.addVideo("Video1");
        manager.addVideo("Video2");
        manager.addVideo("Video3");
        manager.addVideo("Video4");
        manager.addVideo("Video5");

        final int numThreads = 4;
        final int numVideos = 5;

        ExecutorService service = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < numVideos; i++) {
            for (int j = 0; j < numThreads; j++) {
                int finalI = i;
                service.submit(() ->
                        manager.addView(manager.getViewsMap().keySet().stream()
                                .skip(finalI)
                                .findFirst()
                                .orElse(""))
                );
            }
        }

        service.shutdown();

        try {
            if (!service.awaitTermination(1, TimeUnit.MINUTES)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }
}
