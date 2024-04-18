package faang.school.godbless.synchronization.youtube;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class VideoManagerTest {
    static final int NUM_THREADS = 1000;
    static final int NUM_VIDEOS = 10;
    VideoManager videoManager = new VideoManager();

    @Test
    void testAddViewValidArg() {
        //given
        ExecutorService watchers = Executors.newFixedThreadPool(NUM_THREADS);

        var individualVideoViewsCount = Optional.of(NUM_THREADS / NUM_VIDEOS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            videoManager.uploadVideo(String.valueOf(i));
        }


        //when
        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = String.valueOf(i);
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                watchers.submit(() -> videoManager.addView(videoId));
            }
        }

        var viewsMap = videoManager.getViewsMap();

        watchers.shutdown();

        try {
            watchers.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("The program was interrupted from outside");
        }


        //then
        viewsMap.values().forEach(viewCount -> assertEquals(individualVideoViewsCount.get(), viewCount));
    }

    @Test
    void testAddViewInvalidArg() {
        //given
        videoManager.uploadVideo("1");
        var expectedViewsCountFirstVideo = Optional.of(0);
        var expectedViewsCountSecondVideo = Optional.empty();

        //when
        videoManager.addView(null);
        videoManager.addView("");
        videoManager.addView("2");

        var actualViewsCountFirstVideo = videoManager.getViewCount("1");
        var actualViewsCountSecondVideo = videoManager.getViewCount("2");

        //then
        assertEquals(expectedViewsCountFirstVideo, actualViewsCountFirstVideo);
        assertEquals(expectedViewsCountSecondVideo, actualViewsCountSecondVideo);
    }

    @Test
    void testGetViewCountValidArg() {
        //given
        videoManager.uploadVideo("1");
        var expectedViewsCountAfterUpload = Optional.of(0);
        var expectedViewsCount = Optional.of(3);


        //when
        var actualViewsCountAfterUpload = videoManager.getViewCount("1");

        videoManager.addView("1");
        videoManager.addView("1");
        videoManager.addView("1");

        var actualViewsCount = videoManager.getViewCount("1");


        //then
        assertNotNull(expectedViewsCount);
        assertNotNull(expectedViewsCountAfterUpload);
        assertEquals(expectedViewsCountAfterUpload, actualViewsCountAfterUpload);
        assertEquals(expectedViewsCount, actualViewsCount);
    }

    @Test
    void testGetViewCountInvalidArg() {
        //given
        var expectedViewsCount = Optional.empty();


        //when
        var actualViewsCountForUnmatchedId = videoManager.getViewCount("0");
        var actualViewsCountForInvalidId = videoManager.getViewCount("");
        var actualViewsCountForNullValuedId = videoManager.getViewCount(null);

        //then
        assertNotNull(actualViewsCountForUnmatchedId);
        assertNotNull(actualViewsCountForInvalidId);
        assertNotNull(actualViewsCountForNullValuedId);
        assertEquals(expectedViewsCount, actualViewsCountForUnmatchedId);
        assertEquals(expectedViewsCount, actualViewsCountForInvalidId);
        assertEquals(expectedViewsCount, actualViewsCountForNullValuedId);
    }

    @Test
    void testUploadVideoValidArgs() {
        //given
        videoManager.uploadVideo("1");
        var expectedViewsCountAfterUpload = Optional.of(0);


        //when
        var actualViewsCountAfterUpload = videoManager.getViewCount("1");


        //then
        assertNotNull(expectedViewsCountAfterUpload);
        assertEquals(expectedViewsCountAfterUpload, actualViewsCountAfterUpload);
    }

    @Test
    void testUploadVideoInvalidArgs() {
        //given
        var expectedVideosCount = 0;


        //when
        videoManager.uploadVideo(null);
        videoManager.uploadVideo("");
        videoManager.uploadVideo("   ");

        var actualVideosCount = videoManager.getViewsMap().size();


        //then
        assertEquals(expectedVideosCount, actualVideosCount);
    }
}