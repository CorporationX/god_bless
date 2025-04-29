package school.faang.bjs2_73977;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewersMap = new HashMap<>();
    private final Object viewLocker = new Object();

    public void addView(String videoId) {
        synchronized (viewLocker) {
            viewersMap.compute(videoId, (key, value) -> value == null ? 1 : value + 1);
            viewLocker.notify();
        }
    }

    public Integer getCount(String videoId) {
        synchronized (viewLocker) {
            if (!viewersMap.containsKey(videoId)) {
                try {
                    viewLocker.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread was interrupted");
                }
            }
            return viewersMap.get(videoId);
        }
    }
}
