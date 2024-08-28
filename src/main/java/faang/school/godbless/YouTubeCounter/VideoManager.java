package faang.school.godbless.YouTubeCounter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VideoManager {
    private Map<Integer, Integer> viewsMap;
    private final Object lock = new Object();

    public void addView(int videoId) {
        synchronized (lock) {
            viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
        }
    }

    public int getViewCount(int videoId) {
        synchronized (lock) {
            return viewsMap.get(videoId);
        }
    }
}