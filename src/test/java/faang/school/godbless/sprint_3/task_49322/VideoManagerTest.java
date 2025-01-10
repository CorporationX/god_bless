package faang.school.godbless.sprint_3.task_49322;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class VideoManagerTest {

    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS  = 10;

    private static final int NUM_VIEWS  = 10;

    private static final String CORRECT_VIDEO_ID = "video_1";
    private static final int CORRECT_VIEWING_OF_THE_ADDED_VIDEO = 1;

    private static final String INCORRECT_VIDEO_ID_1 = "";
    private static final String INCORRECT_VIDEO_ID_2 = null;

    private static final Map<String, Integer> CORRECT_VIEWS_MAP_WITH_ONE_VIDEO_ADDED
            = Map.of(CORRECT_VIDEO_ID, CORRECT_VIEWING_OF_THE_ADDED_VIDEO);
    private static final Map<String, Integer> CORRECT_VIEWS_MAP = fillViewsMap();

    private final VideoManager videoManager = new VideoManager();

    @Test
    void testAddView_shouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> videoManager.addView(INCORRECT_VIDEO_ID_1));
        assertThrows(IllegalArgumentException.class, () -> videoManager.addView(INCORRECT_VIDEO_ID_2));
    }

    @Test
    void testAddView() {
        videoManager.addView(CORRECT_VIDEO_ID);
        assertEquals(CORRECT_VIEWS_MAP_WITH_ONE_VIDEO_ADDED, videoManager.getViewsMap());
    }

    @Test
    void testGetViewCount_shouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> videoManager.getViewCount(INCORRECT_VIDEO_ID_1));
        assertThrows(IllegalArgumentException.class, () -> videoManager.getViewCount(INCORRECT_VIDEO_ID_2));
    }

    @Test
    void testGetViewCount() {
        videoManager.addView(CORRECT_VIDEO_ID);
        assertEquals(CORRECT_VIEWS_MAP_WITH_ONE_VIDEO_ADDED.get(CORRECT_VIDEO_ID),
                videoManager.getViewCount(CORRECT_VIDEO_ID));
    }

    @Test
    void testAddViewAndGetViewCount() {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video_" + (i + 1);
            for (int j = 0; j < NUM_VIDEOS; j++) {
                executorService.execute(() -> videoManager.addView(videoId));
            }
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                assertEquals(CORRECT_VIEWS_MAP, videoManager.getViewsMap());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static Map<String, Integer> fillViewsMap() {
        Map<String, Integer> viewsMap = new HashMap<>();
        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video_" + (i + 1);
            viewsMap.put(videoId, NUM_VIEWS);
        }
        return viewsMap;
    }
}