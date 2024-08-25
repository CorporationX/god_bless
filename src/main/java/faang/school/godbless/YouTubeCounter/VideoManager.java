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

    public void addView(int videoId) {
        if (viewsMap.containsKey(videoId)) {
            int currentViews = viewsMap.get(videoId);
            viewsMap.put(videoId, currentViews + 1);
        } else {
            viewsMap.put(videoId, 1);
        }
    }
    public int getViewCount(int videoId) {
        return viewsMap.get(videoId);
    }
}
