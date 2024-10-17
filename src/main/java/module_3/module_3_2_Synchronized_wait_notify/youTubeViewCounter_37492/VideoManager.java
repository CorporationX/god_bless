package module_3.module_3_2_Synchronized_wait_notify.youTubeViewCounter_37492;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@Data
public class VideoManager {
    private final Map<String, Integer> videoMap = new HashMap<>();

    public void addView(String videoId) {
        synchronized (this) {
            videoMap.merge(videoId, 1, Integer::sum);
        }
    }

    public int getViewCount(String videoId) {
        synchronized (this) {
            return videoMap.getOrDefault(videoId, 0);
        }
    }
}
