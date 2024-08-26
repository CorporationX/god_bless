package faang.school.godbless.youtube;

import lombok.Getter;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

@Getter
public class VideoManager {

    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(@NonNull String videoId) {
        synchronized (viewsMap) {
            if (!videoId.isBlank()) {
                System.out.println("Add new viewer to viewsMap " + videoId);
                viewsMap.merge(videoId, 1, Integer::sum);
            }
        }
    }

    public int getViewCount(@NonNull String videoId) {
        synchronized (viewsMap) {
            return viewsMap.getOrDefault(videoId, 0);
        }
    }
}
