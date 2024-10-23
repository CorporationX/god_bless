package gmail.photo.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader photoUploader = new GooglePhotosAutoUploader();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable autoUploadTask = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                photoUploader.startAutoUpload();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException error) {
                    Thread.currentThread().interrupt();
                    System.out.println("Поток автозагрузки был прерван");
                }
            }
        };

        Runnable photoAddingTask = () -> {
            String[] newPhotos = {
                    "мы на море.jpg",
                    "мы с любимым.jpg",
                    "101 роза для меня от любимого.jpg",
                    "мы на закате.jpg",
                    "дурачимся.jpg",
                    "завтрак в постель от любимого.jpg"
            };

            for (String photo : newPhotos) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException error) {
                    Thread.currentThread().interrupt();
                    System.out.println("Поток по добавлению новых фотографий прерван");
                }
                photoUploader.oneNewPhotoAdded(photo);
            }
        };

        executorService.execute(autoUploadTask);
        executorService.execute(photoAddingTask);

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
                System.out.println("Потоки были принудительно остановлены.");
            }
        } catch (InterruptedException error) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            System.out.println("Главный поток был прерван.");
        }

        System.out.println("Работа программы завершена.");
    }
}
