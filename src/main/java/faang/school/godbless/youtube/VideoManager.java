package faang.school.godbless.youtube;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class VideoManager {
    private final Map<String, Integer> viewsMap;

    public void addView(String videoId) {
        synchronized (viewsMap) {
            viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);

            makeDelay();
        }
    }

    public void getViewCount(String videoId) {
        synchronized (viewsMap) {
            makeDelay();

            if (!viewsMap.containsKey(videoId)) {
                throw new IllegalArgumentException("There is no such videos");
            }

            int viewsNumber = viewsMap.get(videoId);

            System.out.println(videoId + " has " + viewsNumber + " views");
        }
    }

    private void makeDelay() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
