package school.faang.task_61719;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private static final int DEFAULT_NUMBER_VIEWS = 0;
    private static final String ADDING_VIEW_MESSAGE
            = "Количество просмотров для видео № %s увеличено. Текущее количество просмотров %d%n";

    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        synchronized (viewsMap) {
            viewsMap.merge(videoId, 1, Integer::sum);
            System.out.printf(ADDING_VIEW_MESSAGE, videoId, getView(videoId));
        }
    }

    public Integer getView(String videoId) {
        synchronized (viewsMap) {
            return viewsMap.getOrDefault(videoId, DEFAULT_NUMBER_VIEWS);
        }
    }
}
