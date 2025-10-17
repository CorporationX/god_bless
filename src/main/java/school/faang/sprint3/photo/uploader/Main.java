package school.faang.sprint3.photo.uploader;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class Main {

    private static final Integer TIME_AWAIT_MINUTE = 5;
    private static final Integer THREAD_COUNT = 2;
    private static final Integer FILE_PATH_LENGTH_MAX = 10;
    private static final Integer FREQUENCY_OF_ADDING_SECONDS_MAX = 2;
    private static final Integer FREQUENCY_OF_UPLOADING_SECONDS_MAX = 5;
    private static final Integer PHOTO_AMOUNT_MAX = 5;
    private static final GooglePhotosAutoUploader googlePhotosAutoUploader =
            new GooglePhotosAutoUploader(new LinkedList<>());

    private static final Random random = new Random();
    private static final LongAdder photoCount = new LongAdder();

    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(THREAD_COUNT);
        executors.execute(createAdder());
        executors.execute(createUploader());
        gracefullyShutdown(executors);
    }

    public static void gracefullyShutdown(ExecutorService executorService) {
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(TIME_AWAIT_MINUTE, TimeUnit.MINUTES)) {
                System.out.println("Фото успешно загружены");
            } else {
                System.out.println("Ошибка ожидания завершения работы");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Ошибка при остановке потоков");
        }
    }

    private static Runnable createUploader() {
        return () -> {
            while (photoCount.sum() < PHOTO_AMOUNT_MAX) {
                googlePhotosAutoUploader.startAutoUpload();
                photoCount.increment();
                try {
                    Thread.sleep(TimeUnit.SECONDS.toMillis(FREQUENCY_OF_UPLOADING_SECONDS_MAX));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.printf("Ошибка метода sleep() %s", e.getMessage());
                }
            }
        };
    }

    private static Runnable createAdder() {
        return () -> {
            while (photoCount.sum() < PHOTO_AMOUNT_MAX) {
                googlePhotosAutoUploader.onNewPhotoAdded(generateString());
                try {
                    Thread.sleep(TimeUnit.SECONDS.toMillis(FREQUENCY_OF_ADDING_SECONDS_MAX));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.printf("Ошибка метода sleep() %s", e.getMessage());
                }
            }
        };
    }

    private static String generateString() {
        int filePathLength = random.nextInt(FILE_PATH_LENGTH_MAX) + 1;
        return RandomStringUtils.secure().nextAlphabetic(filePathLength);
    }
}
