package faang.school.godbless.thirdSprint.YouTube;

import lombok.Setter;

import java.util.Map;

@Setter
public class VideoManager {
    private Map<Integer, Video> videos;
    private Map<Video, Integer> viewsMap;

    public void addView(int videoId) {
        Video video = videos.get(videoId);
        viewsMap.put(video, viewsMap.get(video) + 1);
    }

    public int getViewCount(int videoId) {
        Video video = videos.get(videoId);
        return viewsMap.get(video);
    }
}
