package youtube;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class VideoManager {
    private final Map<Video, Integer> viewsMap = new HashMap<>();

    public void addView(@NonNull Video video) {
        synchronized (video.getId()) {
            viewsMap.merge(video, 1, Integer::sum);
        }
    }

    public int getViewCount(@NonNull Video video) {
        synchronized (video.getId()) {
            if (viewsMap.containsKey(video)) {
                return viewsMap.get(video);
            } else {
                throw new IllegalArgumentException("Don't have video with this id");
            }
        }
    }
}
