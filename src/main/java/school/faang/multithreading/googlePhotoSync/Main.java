package school.faang.multithreading.googlePhotoSync;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        List<String> photos = List.of("photo1", "photo2", "photo3", "photo4", "photo5", "photo6"
        , "photo7", "photo8", "photo9", "photo10" , "photo11", "photo12", "photo13", "photo14", "photo15");

        executor.execute(() -> {
            try {
                uploader.startAutoUpload();
            } catch (InterruptedException e) {
                System.out.println("Upload interrupted");
                e.printStackTrace();
            }
        });

        executor.execute(() -> {
            for (String photo : photos) {
                uploader.onNewPhotoAdded(photo);
            }
        });

        executor.shutdown();
    }
}
