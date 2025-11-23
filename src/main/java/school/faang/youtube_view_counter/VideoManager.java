package school.faang.youtube_view_counter;

import lombok.Getter;
import lombok.NonNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Проект: god_bless
 * Класс VideoManager
 * Автор: Vital
 */

@Getter
public class VideoManager {
    //Map для хранения просмотров
    private final Map<String, Integer> viewsMap = new ConcurrentHashMap<>();

    public void addView(@NonNull String videoId) {
        viewsMap.merge(videoId, 1, Integer::sum);
    }

    public int getViewCount(@NonNull String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}