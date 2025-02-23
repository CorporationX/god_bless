package school.faang.sprint3.multithreading.task61990;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@AllArgsConstructor
@Getter
public class VideoManager {
    private volatile Map<String, Integer> viewsMap;

    public synchronized void addView(String videoId) {
        if (viewsMap.containsKey(videoId)) {
            viewsMap.put(videoId, viewsMap.get(videoId) + 1);
        } else {
            log.warn("\nA video with id = {} not found", videoId);
        }
    }

    public synchronized Integer getViewCount(String videoId) {
        if (viewsMap.containsKey(videoId)) {
            return viewsMap.get(videoId);
        } else {
            throw new RuntimeException("\nVideo with id = " + videoId + " not found");
        }
    }
}
