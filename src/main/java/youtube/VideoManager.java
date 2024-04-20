package youtube;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    public static final Map<Integer, Video> VIEWS_MAP = new HashMap<>();

    public void addView(Integer videoId) {
        checkVideoID(videoId);
        synchronized (VIEWS_MAP.get(videoId)) {
            Video video = VIEWS_MAP.get(videoId);
            video.setViews(video.getViews() + 1);
        }

    }

    public int getViewCount(int videoId) {
        checkVideoID(videoId);
        return VIEWS_MAP.get(videoId).getViews();
    }

    private void checkVideo(Video video) {
        if (video == null) {
            throw new NullPointerException("The video must exist");
        }
    }

    private void checkVideoID(int videoId) {
        if (!VIEWS_MAP.containsKey(videoId)) {
            throw new NullPointerException("This video doesn't exist");
        }
    }

    public void addVideo(Video video) {
        checkVideo(video);
        if (!VIEWS_MAP.containsKey(video.getVideoID())) {
            VIEWS_MAP.put(video.getVideoID(), video);
        }
    }

    public Map<Integer, Video> getViewsMap() {
        return VIEWS_MAP;
    }
}
