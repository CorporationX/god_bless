package school.faang.bjs2_81705;

import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Setter
@ToString
public class VideoManager {
    private Map<String, Integer> viewsOfVideo = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsOfVideo.compute(videoId, (key, value) -> value == null ? 1 : value + 1);
        log.info("У видео {} увеличилось количество просмотров на 1", videoId);
    }

    public synchronized int getViewCount(String videoId) {
        return viewsOfVideo.getOrDefault(videoId, 0);
    }



}
