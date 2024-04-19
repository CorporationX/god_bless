package faang.school.godbless.synchronization.youtube;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Getter
public class VideoManager {
    private Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        if (videoId == null || videoId.isBlank()) {
            return;
        }

        viewsMap.computeIfPresent(videoId, (key, value) -> value + 1);

        log.info("One more view added for the video with id = " + videoId + ".");
        log.info("Current number of views for this video: " + getViewCount(videoId));
    }

    public synchronized Optional<Object> getViewCount(String videoId) {
        if (videoId == null || videoId.isBlank()) {
            return Optional.empty();
        }

        return Optional.ofNullable(viewsMap.get(videoId));
    }

    public void uploadVideo(String videoId) {
        if (videoId == null || videoId.isBlank()) {
            return;
        }

        viewsMap.putIfAbsent(videoId, 0);
    }
}
