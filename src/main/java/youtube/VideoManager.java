package youtube;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
public class VideoManager {
    private final Map<UUID, Integer> viewsMap = new HashMap<>();
    private final Map<UUID, Object> videoLocks = new HashMap<>();

    public void addView(@NonNull UUID videoId) {
        if (!videoLocks.containsKey(videoId)) {
            addLockForVideo(videoId);
        }
        synchronized (videoLocks.get(videoId)) {
            viewsMap.merge(videoId, 1, Integer::sum);
        }
    }

    public int getViewCount(@NonNull UUID videoId) {
        if (!videoLocks.containsKey(videoId)) {
            throw new IllegalArgumentException("Don't have lock for video with this id");
        }
        synchronized (videoLocks.get(videoId)) {
            if (viewsMap.containsKey(videoId)) {
                return viewsMap.get(videoId);
            } else {
                throw new IllegalArgumentException("Don't have video with this id");
            }
        }
    }

    private synchronized void addLockForVideo(@NonNull UUID videoId) {
        if (videoLocks.containsKey(videoId)) {
            return;
        }
        videoLocks.put(videoId, new Object());
    }
}
