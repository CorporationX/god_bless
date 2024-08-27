package faang.school.godbless.task.multithreading.youtube.views.counter;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int TREAD_POOL_LIMIT = 100;
    private static final int NUMBER_OF_VIDEOS = 20;
    private static final int VIEWS_PER_VIDEO = TREAD_POOL_LIMIT / NUMBER_OF_VIDEOS;
    private static final int TIME_OUT = 1000;

    private static final VideoManager videoManager = new VideoManager();
    private static final ExecutorService executor = Executors.newFixedThreadPool(TREAD_POOL_LIMIT);
    private static List<String> videoId;

    public static void main(String[] args) {
        videoId = createVideoId();
        videoId.forEach(Main::startWatching);
        executor.shutdown();
        waitEnd();
    }

    private static List<String> createVideoId() {
        return IntStream
                .rangeClosed(1, NUMBER_OF_VIDEOS)
                .mapToObj(i -> "Video_" + i)
                .toList();
    }

    private static void startWatching(String videoId) {
        IntStream.range(0, VIEWS_PER_VIDEO)
                .forEach(i -> executor.execute(() -> watchVideo(videoId)));
    }

    private static void watchVideo(String videoId) {
        videoManager.addView(videoId);
        videoManager.getViewCount(videoId)
                .ifPresentOrElse(
                        view -> log.info("Воспроизведено виде с id: {}, просмотров: {}", videoId, view),
                        () -> log.info("Видео с id: {}, не найдено", videoId));
    }

    private static void waitEnd() {
        try {
            if (executor.awaitTermination(TIME_OUT, TimeUnit.MILLISECONDS)) {
                log.info("Количество просмотров по каждому видео:");
                printAllViews();
            } else {
                log.info("Видео записи не успели воспроизвестись за {} миллисекунд", TIME_OUT);
            }
        } catch (InterruptedException exception) {
            log.error("Interrupted exception: {}", exception.getMessage());
        }
    }

    private static void printAllViews() {
        videoId.forEach(video -> videoManager.getViewCount(video)
                .ifPresent(view -> log.info("id: {}, просмотров: {}", video, view)));
    }
}
