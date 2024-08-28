package faang.school.godbless.bjs2_24451;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class VideoManager {
    private final Map<String, Integer> viewsMap;

    public VideoManager() {
        this.viewsMap = new ConcurrentHashMap<>();
    }

    public void addView(String videoId) {
        log.info(videoId + " +1 view");
        viewsMap.merge(videoId, 1, Integer::sum);
    }

    public int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }

    public void printFinalResult() {
        viewsMap.forEach((k, v) -> System.out.println(k + " = " + v));
    }
}
