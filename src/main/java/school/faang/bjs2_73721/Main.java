package school.faang.bjs2_73721;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {

    private static final int THREAD_TIMEOUT = 5;

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Runnable uploadPhotos = uploader::startAutoUpload;
        Runnable addPhotos = () -> IntStream.range(1, 100).forEach(
                index -> {
                    String newPhoto = "/photos/photo%s.jpg".formatted(index);
                    uploader.onNewPhotoAdded(newPhoto);
                }
        );

        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(addPhotos);
        executor.execute(uploadPhotos);

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        GooglePhotosAutoUploader.turnOff();

        executor.shutdown();

        executorShutdown(executor);
    }

    private static void executorShutdown(ExecutorService executor) {
        try {
            if (!executor.awaitTermination(THREAD_TIMEOUT, TimeUnit.MINUTES)) {
                log.info("Задачи не завершились за {} минут, принудительно останавливаем...", THREAD_TIMEOUT);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
