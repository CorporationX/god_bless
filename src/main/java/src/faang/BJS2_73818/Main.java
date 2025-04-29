package src.faang.BJS2_73818;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_NUMBER = 8;
    private static final int VIDEOS_NUMBER = 20;
    private static final int AWAIT_TERMINATION_TIMEOUT = 10;

    @SneakyThrows
    public static void main(String[] args) {
        final VideoManager videoManager = new VideoManager();
        final ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUMBER);

        for (int i = 0; i < VIDEOS_NUMBER; i++) {
            for (int j = 0; j < THREAD_NUMBER; j++) {
                final int videoNumber = i;
                executor.execute(() -> videoManager.addView(String.valueOf(videoNumber)));
            }
        }

        executor.shutdown();

        if (!executor.awaitTermination(AWAIT_TERMINATION_TIMEOUT, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }

        System.out.println(videoManager.getViewsMap());
    }
}

