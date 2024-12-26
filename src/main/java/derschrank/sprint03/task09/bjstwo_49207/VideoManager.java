package derschrank.sprint03.task09.bjstwo_49207;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoManager implements VideoManagerInterface {
    private final Map<String, AtomicInteger> viewsMap;

    public VideoManager() {
        viewsMap = new ConcurrentHashMap<String, AtomicInteger>();
    }

    @Override
    public void addView(String videoId) {
        viewsMap.computeIfAbsent(videoId, key -> new AtomicInteger(0)).incrementAndGet();
    }

    @Override
    public int getViewCount(String videoId) {
        return viewsMap.get(videoId).get();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Table of views:\n");
        for (String videoId : viewsMap.keySet()) {
            result.append(videoId)
                    .append(" has views: ")
                    .append(viewsMap.get(videoId))
                    .append("\n");
        }
        return result.toString();
    }
}
