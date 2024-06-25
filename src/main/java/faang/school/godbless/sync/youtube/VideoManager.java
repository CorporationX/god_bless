package faang.school.godbless.sync.youtube;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoManager {

    private final Map<String, Integer> viewsMap;

    public VideoManager() {
        this.viewsMap = new ConcurrentHashMap<>();
    }

    public void addView(String videoId) {
        validateVideo(videoId);
        this.viewsMap.merge(videoId, 1, Integer::sum);
    }

    public int getViewCount(String videoId) {
        validateVideo(videoId);
        return this.viewsMap.getOrDefault(videoId, 0);
    }

    private static void validateVideo(String videoId) {
        if (videoId == null || videoId.isEmpty()) {
            throw new IllegalArgumentException("Invalid video id");
        }
    }
}
