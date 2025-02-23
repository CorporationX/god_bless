package bjs261587;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@AllArgsConstructor
@Getter
public class VideoManager implements Runnable {
    private volatile Map<String, Long> viewsMap;
    private final Object lock = new Object();
    private static final int TASK_DURATION_MS = 1000;
    private static final Logger LOGGER = LoggerFactory.getLogger(VideoManager.class);

    public void addView(String videoId) {
        synchronized (lock) {
            validateVideoId(videoId);
            viewsMap.merge(videoId, 1L, (id, viewsNumber) -> viewsMap.get(videoId) + 1);
            LOGGER.info("Thread {} has added {}, number of views video {} is {}",
                    Thread.currentThread().getName(), videoId, videoId, getViewCount(videoId));
        }
    }

    public Long getViewCount(String videoId) {
        synchronized (lock) {
            validateVideoId(videoId);
            return viewsMap.get(videoId);
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(TASK_DURATION_MS);
        } catch (InterruptedException e) {
            LOGGER.error("Thread {} started, but not completed due to InterruptedException",
                    Thread.currentThread().getName());
            throw new RuntimeException(e);
        }
    }

    private void validateVideoId(String videoId) {
        if (videoId == null) {
            throw new IllegalArgumentException("Video cannot be null");
        }
    }
}
