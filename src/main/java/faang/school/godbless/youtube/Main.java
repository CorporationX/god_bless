package faang.school.godbless.youtube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {

        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String videoId = "videoId: " + i;
            for(int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++){
                executor.execute(()->{
                    videoManager.addView(videoId);
                    System.out.println("Video " + videoId + " view counter: " + videoManager.getViewCount(videoId));
                });
            }
        }
        executor.shutdown();
        try{
            if(!executor.awaitTermination(30, TimeUnit.SECONDS)){
                System.out.println("Not all tasks were completed");
            }
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        videoManager.getViewsMap().forEach((key, value)-> System.out.println(key + " : " + value));
    }
}
