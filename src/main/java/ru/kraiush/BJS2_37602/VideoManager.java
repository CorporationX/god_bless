package ru.kraiush.BJS2_37602;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
    }

    public synchronized void getViewCount(String videoId) {
        System.out.println("The video " + videoId + " has " + viewsMap.getOrDefault(videoId, 0) + " views.");
    }
}
