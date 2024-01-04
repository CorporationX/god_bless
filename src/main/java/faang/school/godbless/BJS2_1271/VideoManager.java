package faang.school.godbless.BJS2_1271;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class VideoManager {
    private Map<Video, Integer> viewsMap = new HashMap<>();
    private List<Video> videos = new ArrayList<>();


    public synchronized void addView(Video video) {
        viewsMap.merge(video, 1, Integer::sum);
    }

    public synchronized int getViewCount(Video video) {
        return viewsMap.getOrDefault(video, 0);
    }

    public void initialize(int num) {
        for (int i = 0; i < num; i++) {
            videos.add(new Video("www.video." + (i + 1)));
        }
    }
}