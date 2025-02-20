package school.faang.viewingcounter;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class VideoManager {
    private static final int MAX_EXECUTION_TIME = 500;
    private static final int MIN_EXECUTION_TIME = 300;
    private static final int DEFAULT_VIEW_NEW_VIDEO = 0;
    private static final int ADD_VIEW_NUMBER = 1;

    private final Map<String, Integer> viewsMap = new HashMap<>();
    private final Object viewLock = new Object();

    public void addView(String viewName) throws InterruptedException {
        validateNameAndImitationDelay(viewName);
        synchronized (viewLock) {
            viewsMap.put(viewName, viewsMap.getOrDefault(viewName, DEFAULT_VIEW_NEW_VIDEO) + ADD_VIEW_NUMBER);
            log.info("Changing view {} on video {}", viewsMap.get(viewName), viewName);
            viewLock.notifyAll();
        }
    }

    public void getViewCount(String viewName) throws InterruptedException {
        validateNameAndImitationDelay(viewName);
        synchronized (viewLock) {
            if (!viewsMap.containsKey(viewName)) {
                viewLock.wait();
            }
            log.info("Video name: {}, view count: {}", viewName, viewsMap.get(viewName));
        }
    }

    private void validateNameAndImitationDelay(String viewName) throws InterruptedException {
        Thread.sleep((long) (Math.random() * MAX_EXECUTION_TIME + MIN_EXECUTION_TIME));
        Objects.requireNonNull(viewName, "Invalid view name");
    }
}
