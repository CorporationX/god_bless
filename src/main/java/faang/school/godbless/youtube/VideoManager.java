package faang.school.godbless.youtube;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class VideoManager {
    private Map<Video, Integer> viewsMap = new HashMap<>();

    public VideoManager(Map<Video, Integer> viewsMap) {
        this.viewsMap.putAll(viewsMap);//чтобы объект можно было менять
    }

    public void addVideo(Video video, int views) {
        viewsMap.put(video, views);
    }

    public int getViewCount(Video video) {
        synchronized (viewsMap.get(video)) {//использую именно это в качестве лока,
            // чтобы не блокировать остальные видео
            // (при использовании такого лока для каждого видео гарантирован свой лок)
            return viewsMap.get(video);
        }
    }

    public void addView(Video video) {
        synchronized (viewsMap.get(video)) {
            viewsMap.put(video, viewsMap.get(video) + 1);
        }
    }
}
