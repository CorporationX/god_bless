package school.faang.bjs2_90555;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final String PHOTO_PATH_ONE = "Photo Path number One";
    private static final String PHOTO_PATH_TWO = "Photo Path number Two";
    private static final String PHOTO_PATH_TREE = "Photo Path number Tree";
    private static final int THREAD_COUNT = 2;
    private static final int MAX_AWAIT_MINUTE = 1;

    public static void main(String[] args) {
        GooglePhotoAutoUploader photoAutoUploader = new GooglePhotoAutoUploader();
        List<Runnable> runlist = List.of(
                () -> photoAutoUploader.onNewPhotoAdded(PHOTO_PATH_ONE),
                photoAutoUploader::startAutoUploader,
                () -> photoAutoUploader.onNewPhotoAdded(PHOTO_PATH_TWO),
                () -> photoAutoUploader.onNewPhotoAdded(PHOTO_PATH_TREE),
                photoAutoUploader::startAutoUploader);
        ExecutorService executors = Executors.newFixedThreadPool(THREAD_COUNT);
        for (Runnable runnable : runlist) {
            executors.submit(runnable);
        }
        executors.shutdown();
        try {
            if (!executors.awaitTermination(MAX_AWAIT_MINUTE, TimeUnit.MINUTES)) {
                log.info("Потоки не обработали задачи за {} минут. Останавливаем Потоки", MAX_AWAIT_MINUTE);
                executors.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info("Прерывание в работе ожидания потоков");
            executors.shutdownNow();
        }
    }
}
