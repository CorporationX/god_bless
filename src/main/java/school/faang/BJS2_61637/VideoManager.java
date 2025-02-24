package school.faang.BJS2_61637;

import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class VideoManager {

    private final Map<String, Integer> viewsMap = new ConcurrentHashMap<>();

    public void addView(String videold) {
        viewsMap.compute(videold, (k, v) -> (v == null) ? 1 : v + 1);
    }

    public int getViewCount(String videold) {
        return viewsMap.getOrDefault(videold, 0);
    }
}
