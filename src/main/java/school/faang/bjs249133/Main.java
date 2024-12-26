package school.faang.bjs249133;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 1;
    public static final int TIME_DELAY_FINISH = 1;
    public static final int NUMBER_FILES = 30;
    public static final int TIME_PAUSE = 500;
    public static final int SERVICE_OPENING_HOURS = 5;

    public static void main(String[] args) {

        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();
        Thread uploadThread = new Thread(autoUploader::startAutoUpload);
        uploadThread.setDaemon(true);
        uploadThread.start();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        Runnable task = () -> {
            System.out.println("Сервис начал работу...");

            for (int i = 0; i < NUMBER_FILES; i++) {
                autoUploader.onNewPhotoAdded(String.format("photo%s.jpg", i));

                try {
                    Thread.sleep(TIME_PAUSE);
                } catch (InterruptedException ex) {
                    log.error("Interrupted Uploader {}", String.valueOf(ex));
                    throw new RuntimeException(ex);
                }
            }

            System.out.println("Сервис завершил работу.");
        };

        Future<?> future = executor.submit(task);

        try {
            future.get(SERVICE_OPENING_HOURS, TimeUnit.SECONDS);
        } catch (TimeoutException ex) {
            log.error("Время работы истекло! Прерываем поток... {}", String.valueOf(ex));
            future.cancel(true);
        } catch (InterruptedException | ExecutionException ex) {
            log.error("Error interrupted! {}", String.valueOf(ex));
        } finally {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(TIME_DELAY_FINISH, TimeUnit.SECONDS)) {
                    System.out.println("Принудительное завершение пула потоков.");
                    executor.shutdownNow();
                }
            } catch (InterruptedException ex) {
                executor.shutdownNow();
                log.error("Everything is bad! {}", String.valueOf(ex));
            }
        }


    }
}
