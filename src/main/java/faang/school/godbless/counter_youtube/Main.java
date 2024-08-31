package faang.school.godbless.counter_youtube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        final int numThreads = 100;

        ExecutorService poolThreads = Executors.newFixedThreadPool(numThreads);

        Video video1 = new Video("Как сварить пельмени", "1");
        Video video2 = new Video("Программирование для новчиков", "2");
        Video video3 = new Video("Baby Shark", "3");
        Video video4 = new Video("Just do it", "4");
        Video video5 = new Video("Welcom to Russia", "5");

        videoManager.addVideo(video1);
        videoManager.addVideo(video2);
        videoManager.addVideo(video3);
        videoManager.addVideo(video4);
        videoManager.addVideo(video5);

        final int numVideos = videoManager.getVideos().size();

        for (Video video : videoManager.getVideos()) {
            for (int j = 0; j < numThreads / numVideos; j++) {
                poolThreads.submit(() -> {
                    videoManager.addView(video);

                });
            }
        }

        poolThreads.shutdown();

        try {
            poolThreads.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (Video video : videoManager.getVideos()) {
            System.out.println("Текущее количество просмотров " + video.getName()
                    + " " + videoManager.getViewCount(video));
        }
    }
}
