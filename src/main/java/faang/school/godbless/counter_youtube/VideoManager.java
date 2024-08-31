package faang.school.godbless.counter_youtube;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
public class VideoManager {
    private static final Map<String, Integer> viewsMap = new HashMap<>();
    private List<Video> videos = new ArrayList<>();
    private final Object lock = new Object();

    public void addVideo(Video video) {
        videos.add(video);
        viewsMap.put(video.getId(), 0);
    }

    public void addView(Video video) {
        synchronized (lock) {
            viewsMap.put(video.getId(), viewsMap.get(video.getId()) + 1);
        }
    }

    public int getViewCount(Video video) {
        synchronized (lock) {
            return viewsMap.getOrDefault(video.getId(), 0);
        }
    }
}
