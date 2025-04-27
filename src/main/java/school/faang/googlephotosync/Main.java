package school.faang.googlephotosync;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        GooglePhotoAutoUploader uploader = new GooglePhotoAutoUploader();

        int producerCount = 3;  // кол-во потоков, генерирующих фото
        int consumerCount = 2;  // кол-во автозагрузчиков
        int runSeconds = 5; // сколько секунд гонять демо

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < consumerCount; i++) {
            int uploaderId = i + 1;
            executor.submit(() -> {
                Thread.currentThread().setName("Uploader-" + uploaderId);
                uploader.startAutoUpload();
            });
        }
        for (int i = 0; i < producerCount; i++) {
            int producerId = i + 1;
            executor.submit(() -> {
                Thread.currentThread().setName("Producer-" + producerId);
                Random rnd = new Random();
                String[] sampleDirs = {"holiday", "family", "work", "nature"};
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        String dir = sampleDirs[rnd.nextInt(sampleDirs.length)];
                        String name = "photo_" + System.currentTimeMillis() + ".jpg";
                        String path = dir + "/" + name;

                        uploader.onNewPhotoAdded(path);
                        System.out.println(Thread.currentThread().getName()
                                + " added " + path);

                        // Ждём от 200 до 1000 мс
                        Thread.sleep(200 + rnd.nextInt(800));
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Thread {} was interrupted while sleeping.", Thread.currentThread().getName());
                }
            });
        }
        try {
            TimeUnit.SECONDS.sleep(runSeconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread {} was interrupted while sleep.", Thread.currentThread());
            return;
        }

        executor.shutdownNow();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("=== Shutting down demo after 5 seconds ===");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread {} was interrupted while sleep.", Thread.currentThread());
            return;
        }
        System.out.println("=== Demo finished ===");
    }
}
