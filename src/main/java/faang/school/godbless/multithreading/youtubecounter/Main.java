package faang.school.godbless.multithreading.youtubecounter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 5;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        Map<String, Integer> videos = createVideos();
        VideoManager videoManager = new VideoManager(videos);

        videos.entrySet().forEach(video -> {
            int threadsForVideo = NUM_THREADS / NUM_VIDEOS;

            while(threadsForVideo > 0){
                executorService.execute(() -> {
                    videoManager.addView(video.getKey());
                    videoManager.getViewCount(video.getKey());
                });

                threadsForVideo--;
            }
        });

        executorService.shutdown();

        executorService.awaitTermination(5, TimeUnit.SECONDS);

        videos.forEach((key, value) -> System.out.println("> " + key + " has: " + value));
    }

    private static Map<String, Integer> createVideos(){
        Map<String, Integer> videos = new HashMap<>();

        for (int i = 0; i < NUM_VIDEOS; i++) {
            videos.put("video " + i, 0);
        }

        return videos;
    }

}
