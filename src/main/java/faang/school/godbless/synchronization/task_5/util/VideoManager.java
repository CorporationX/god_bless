package faang.school.godbless.synchronization.task_5.util;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> views = new HashMap<>();

    public synchronized void addView(String videoId) {
        views.computeIfPresent(videoId, (video, views) -> views + 1);
        System.out.println("видео " + videoId + " посмотрел еще 1 человек");
        System.out.println("общее количество просмотров видео " + videoId + " : " + getViewCount(videoId));

    }

    public synchronized int getViewCount(String videoId) {
        return views.getOrDefault(videoId, 0);
    }

    public void uploadVideo(String videoId) {
        views.putIfAbsent(videoId, 0);
    }


}