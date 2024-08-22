package faang.school.godbless.youTubeViews;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Getter
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView (String videoId) {
        if (viewsMap.containsKey(videoId)) {
            viewsMap.put(videoId, viewsMap.get(videoId) + 1);
            System.out.println("A view added to video with id " + videoId);
        } else {
            System.out.println("Video with id " + videoId + " not found");
        }
    }

    public Optional<Integer> getViewCount (String videoId) {
        return Optional.ofNullable(viewsMap.get(videoId));
    }

    public void addVideo (String videoId) {
        if (!viewsMap.containsKey(videoId)) {
            viewsMap.put(videoId, 0);
        } else {
            System.out.println("Video with id: " + videoId + " already exists");
        }
    }
}
