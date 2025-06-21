package school.faang.viewcounter;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;


@Slf4j
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap(Map.of("0", 31, "1", 432, "2", 3423,
            "3", 312, "4", 423423, "5", 12,
            "6", 54353, "7", 987, "8", 654));

    public synchronized void addView(String videoId) {
        if (viewsMap.containsKey(videoId)) {
            int count = viewsMap.get(videoId);
            viewsMap.put(videoId, ++count);
        } else {
            log.info("Невозможно обновить количество просмотров для несуществующего видеоролика.");
        }
    }

    public synchronized Integer getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}
