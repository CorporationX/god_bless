package faang.school.godbless.sprint_3.multithreading.youtube_counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final Integer NUM_THREADS = 100;
    private static final Integer NUM_VIDEOS = 25;

    public static void main(String[] args) {
        VideoManager first = new VideoManager();
        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);
        int difference = NUM_THREADS / NUM_VIDEOS;
        for (int i = 0; i < NUM_VIDEOS; i++) {
            String video = "New video # " + i;
            for (int j = 0; j < difference; j++) {
                service.submit(() -> {
                    first.addView(video);
                    System.out.printf("Количество просмотров у %s = %d.%n", video, first.getViewCount(video));
                });
            }
        }
        service.shutdown();
        try {
            service.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}
