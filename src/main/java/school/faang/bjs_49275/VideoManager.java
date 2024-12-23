package school.faang.bjs_49275;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String viewName) {
        synchronized (viewsMap) {
            if (!viewsMap.containsKey(viewName)) {
                viewsMap.put(viewName, 0);
            }
            log.info("Add view: {}", viewName);
            viewsMap.put(viewName, viewsMap.get(viewName) + 1);
        }
    }

    public int getViewCount(String viewName) {
        synchronized (viewsMap) {
            return viewsMap.get(viewName);
        }
    }
}
