package school.faang.bjs2_90122;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class VideoManager {

    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
    }

    public synchronized void getViewCount(String videoId) {
        System.out.printf("Video %s has %d views.%n", videoId, viewsMap.get(videoId));
    }
}
