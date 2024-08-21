package youtube;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static final int NUM_THREADS = 100;
    public static final int NUM_VIDEOS = 20;

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager(new Object());
        var videos = initVideos();
        try (ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS)) {
            IntStream.rangeClosed(0, videos.size())
                    .boxed()
                    .flatMap(i -> IntStream.range(0, NUM_THREADS / NUM_VIDEOS).boxed()
                            .map(j -> i))
                    .forEach(idx -> executor.submit(() -> {
                        var videoId = videos.get(idx);
                        videoManager.addView(videoId);
                        System.out.printf("Video with id=%s is %d%n",
                                videoId, videoManager.getViewCount(videoId));
                    }));
            executor.shutdown();
            executor.awaitTermination(30, TimeUnit.SECONDS);
        }
        System.out.println();
        videos.forEach(v -> System.out.printf("Video with id=%s is %d%n", v, videoManager.getViewCount(v)));
    }

    private static List<String> initVideos() {
        Random rand = new Random();
        List<String> videoIds = new ArrayList<>();
        for (int i = 0; i < NUM_VIDEOS; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 10; j++) {
                sb.append(Character.toString(rand.nextInt(94) + 33));
            }
            videoIds.add(sb.toString());
        }

        return videoIds;
    }
}
