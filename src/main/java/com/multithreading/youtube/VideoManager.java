package com.multithreading.youtube;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class VideoManager {
    private static final int NUM_TREADS = 100;
    private static final int NUM_VIDEO = 100;

    private final Map<String, Integer> viewsMap = new HashMap<>();
    private final Object lock = new Object();

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        ExecutorService service = Executors.newFixedThreadPool(NUM_TREADS);

        for (int i = 0; i < NUM_VIDEO; i++) {
            String videoId = "video " + i;
            service.execute(() -> videoManager.addView(videoId));
            service.execute(() -> {
                        int count = videoManager.getViewCount(videoId);
                        System.out.println(count);
                    }
            );

        }
        service.shutdown();
        try {
            service.awaitTermination(10, TimeUnit.SECONDS);
            service.shutdownNow();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void addView(String videoId) {
        if (videoId.isEmpty() && videoId.isBlank()) {
            Thread.currentThread().interrupt();
        }
        synchronized (lock) {
            if (viewsMap.containsKey(videoId)) {
                int value = viewsMap.get(videoId);
                viewsMap.put(videoId, value + 1);
            } else {
                viewsMap.put(videoId, 1);
            }
        }
    }

    public int getViewCount(String videoId) {
        synchronized (lock) {
            return viewsMap.getOrDefault(videoId, 0);
        }
    }

}
