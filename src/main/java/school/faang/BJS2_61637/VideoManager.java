package school.faang.BJS2_61637;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class VideoManager {

    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videold) {
        viewsMap.compute(videold, (k, v) -> (v == null) ? 1 : v + 1);
    }

    public int getViewCount(String videold) {
        return viewsMap.get(videold);
    }
}
