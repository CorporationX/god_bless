package school.faang.sprint3.task_49292;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class VideoManager {
    @NonNull
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        Integer value = viewsMap.merge(videoId, 1, Integer::sum);
        log.info(Thread.currentThread().getName() + "| " + videoId + " | " + value);
    }

    public void printViewCount() {
        viewsMap.entrySet().stream()
                .forEach(System.out::println);
    }

    public void addVideo(String videoId) {
        viewsMap.putIfAbsent(videoId, 0);
    }
}

