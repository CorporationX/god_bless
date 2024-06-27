package faang.school.godbless.sprint_3.multithreading_synchronization.task_5_youtube;

import java.util.Map;

public class VideoManager {
    public static final String MSG_IS_NOT_CONTAINES = "видео с таки id не существует.";
    private final Map<String, Integer> viewsMap;

    public VideoManager(Map<String, Integer> viewsMap) {
        this.viewsMap = viewsMap;
    }

    public void addView(String videoId) {
        synchronized (viewsMap) {
            validateVideoId(videoId);
            int count = viewsMap.get(videoId);
            viewsMap.put(videoId, ++count);
        }
    }

    public int getViewCount(String videoId) {
        synchronized (viewsMap) {
            validateVideoId(videoId);
            return viewsMap.get(videoId);
        }
    }

    private void validateVideoId(String videoId) {
        if (!viewsMap.containsKey(videoId)) {
            throw new RuntimeException(MSG_IS_NOT_CONTAINES);
        }
    }

}
