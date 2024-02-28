package faang.school.godbless.youuubeviewscounter2976;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();
    private final Object VIEWS_LOCK = new Object();

    public void addView(String videoId) {
        synchronized (this.VIEWS_LOCK) {
            if (!this.getViewsMap().containsKey(videoId)) {
                this.getViewsMap().put(videoId, 1);
                return;
            }
            this.getViewsMap().put(videoId, this.getViewsMap().get(videoId) + 1);
        }
    }

    public int getViewCount(String videoId) {
        synchronized (this.VIEWS_LOCK) {
            if (!this.getViewsMap().containsKey(videoId)) {
                return 0;
            }
            return this.getViewsMap().get(videoId);
        }
    }
}
