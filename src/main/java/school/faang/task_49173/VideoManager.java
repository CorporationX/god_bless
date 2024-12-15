package school.faang.task_49173;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@AllArgsConstructor
public class VideoManager {
    private static final Object LOCK = new Object();
    private Map<String, Integer> viewsMap;

    public void addView(String videoId) {
        if (StringUtils.isBlank(videoId)) {
            throw new IllegalArgumentException("The videoId is blank!");
        }
        viewsMap.merge(videoId, 1, Integer::sum);
    }

    public synchronized void getViewCount(String videoId) {
        if (StringUtils.isBlank(videoId)) {
            throw new IllegalArgumentException("The videoId is blank!");
        }
        System.out.println(viewsMap.get(videoId));
    }
}
