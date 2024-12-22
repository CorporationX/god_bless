package school.faang.bjs249591;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {

    @Getter
    private Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        synchronized (this) {
            System.out.printf("Video with : %s is uploading...\n", videoId);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            viewsMap.compute(videoId, (key, value) -> (value == null) ? 1 : value + 1);
            System.out.printf("Video with : %s uploaded\n", videoId);
        }
    }

    public Integer getViewCount(String videoId) {
        synchronized (this) {
            return viewsMap.getOrDefault(videoId, 0);
        }
    }

}
