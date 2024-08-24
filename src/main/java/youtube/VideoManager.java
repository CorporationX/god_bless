package youtube;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class VideoManager {
    private final Map<Video, Integer> viewsMap = new HashMap<>();
    private final Map<Video, Object> videoLocks = new HashMap<>();

    public void addView(@NonNull Video video) {
        if (!videoLocks.containsKey(video)) {
            addLockForVideo(video);
        }
        synchronized (videoLocks.get(video)) {
            viewsMap.merge(video, 1, Integer::sum);
        }
    }

    public int getViewCount(@NonNull Video video) {
        if (!videoLocks.containsKey(video)) {
            throw new IllegalArgumentException("Don't have lock for video with this id");
        }
        synchronized (videoLocks.get(video)) {
            if (viewsMap.containsKey(video)) {
                return viewsMap.get(video);
            } else {
                throw new IllegalArgumentException("Don't have video with this id");
            }
        }
    }

    private synchronized void addLockForVideo(@NonNull Video video) {
        if (!videoLocks.containsKey(video)) {
            videoLocks.put(video, new Object());
        }
    }
}
