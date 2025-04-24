package school.faang.stream3.synchronization.googlephotosync;

public class Main {
    public static void main(String[] args) {

        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Поток для добавления новых фотографий
        executor.execute(() -> {
            for (int i = 1; i <= 5; i++) {
                uploader.onNewPhotoAdded("photo" + i + ".jpg");
                try {
                    Thread.sleep(500); // Задержка между добавлением фотографий
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Поток для добавления новых фотографий
        executor.execute(() -> {
            for (int i = 6; i <= 10; i++) {
                uploader.onNewPhotoAdded("photo" + i + ".jpg");
                try {
                    Thread.sleep(700); // Задержка между добавлением фотографий
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        executor.shutdown();
    }
}
