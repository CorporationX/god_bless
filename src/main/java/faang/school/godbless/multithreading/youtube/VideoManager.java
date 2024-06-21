package faang.school.godbless.multithreading.youtube;

import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
public class VideoManager {
    private final Map<Integer, Integer> viewsMap;
    private int currentView = 0;

    public VideoManager() {
        this.viewsMap = new HashMap<>();
    }

    public void addViews(Video video) {
        synchronized (viewsMap) {
            int views = viewsMap.get(video.getVideoId()) + 1;
            viewsMap.put(video.getVideoId(), views);
            getViews(video);
        }
    }

    public void getViews(Video video) {
        System.out.println("Video " + video.getVideoName() + " id " + video.getVideoId() + " has  "
                + viewsMap.get(video.getVideoId()) + " views");
    }

    public void UploadVideo(List<Video> videos) {
        for (Video video : videos) {
            viewsMap.put(video.getVideoId(), 0);
        }
    }
}
