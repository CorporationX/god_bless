package school.faang.bjs2_81756;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        synchronized (viewsMap) {
            viewsMap.putIfAbsent(videoId, 0);
            int views = viewsMap.get(videoId) + 1;
            viewsMap.put(videoId, views);
        }
    }

    public int getViewCount(String videoId) {
        synchronized (viewsMap) {
            if (Objects.isNull(viewsMap.get(videoId))) {
                System.out.println("Video is not found");
                return -1;
            }
            return viewsMap.get(videoId);
        }
    }
}
