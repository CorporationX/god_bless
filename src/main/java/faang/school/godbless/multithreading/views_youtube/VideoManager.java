package faang.school.godbless.multithreading.views_youtube;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class VideoManager {
    private volatile Map<Integer, Integer> views;

    public synchronized void addView(int videoId) {
        views.merge(videoId, 1, Integer::sum);
        System.out.printf("Added view to video-%s | %s\n", videoId, Thread.currentThread().getName());
    }

    public synchronized void getViewCount(int videoId) {
        System.out.printf("Video-%s views %s | %s\n", videoId, views.get(videoId), Thread.currentThread().getName());
    }
}
