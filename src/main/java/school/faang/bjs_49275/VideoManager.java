package school.faang.bjs_49275;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String viewName) {
        synchronized (viewsMap) {
            viewsMap.putIfAbsent(viewName, 0);
            viewsMap.put(viewName, viewsMap.get(viewName) + 1);
        }
        log.info("Add view: {}", viewName);
    }

    public int getViewCount(String viewName) {
        synchronized (viewsMap) {
            return viewsMap.get(viewName);
        }
    }
}
