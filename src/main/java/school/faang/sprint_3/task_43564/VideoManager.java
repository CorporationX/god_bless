package school.faang.sprint_3.task_43564;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Getter
public class VideoManager {
    private final Map<String, Integer> views = new HashMap<>();

    public synchronized void addView(String videoId) {
        Integer videoViews = views.get(videoId);
        try {
            isVideoExist(videoViews);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        views.put(videoId, videoViews + 1);
        System.out.println("Количество просмотров \"" + videoId + "\" увеличено");
    }

    public synchronized void getViewCount(String videoId) {
        Integer videoViews = views.get(videoId);
        try {
            isVideoExist(videoViews);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(videoId + ": всего просмотров - " + videoViews);
    }

    private void isVideoExist(Integer videoViews) throws NoSuchElementException {
        if (videoViews == null) {
            throw new NoSuchElementException("Видео с таким id нет!");
        }
    }
}
