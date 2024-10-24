package school.faang.Mnogopotochka.Synhronaized.BJS2_37464;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private static final Logger log = LoggerFactory.getLogger(VideoManager.class);
    private Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videold) {
        if (videold == null || videold.isEmpty()) {
            log.warn("Попытка добавить просмотр с недопустимым идентификатором видео.");
            return;
        }
        int currentViews = viewsMap.getOrDefault(videold, 0);
        viewsMap.put(videold, currentViews + 1);
    }

    public synchronized int getViewCount(String videold) {
        if (videold == null || videold.isEmpty()) {
            log.warn("Попытка получить количество просмотров с недопустимым идентификатором видео.");
            return 0;
        }
        return viewsMap.getOrDefault(videold, 0);
    }

    public void displayAllVideo(){
        viewsMap.forEach((key,value) -> log.info("Video ID: {} | Views: {}", key, value));
    }
}
