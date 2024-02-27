package faang.school.godbless.r_edzie.synchronization.photo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREAD_AMOUNT = 3;

    public static void main(String[] args) throws InterruptedException {
        GooglePhoto googlePhoto = new GooglePhoto();
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_AMOUNT);
        executorService.execute(() -> {
            try {
                googlePhotosAutoUploader.startAutoUpload(googlePhoto);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        googlePhotosAutoUploader.onNewPhotoAdded("/1");
        googlePhotosAutoUploader.onNewPhotoAdded("/2");
        googlePhotosAutoUploader.onNewPhotoAdded("/3");

        System.out.println(googlePhotosAutoUploader.getPhotosToUpload());

        executorService.execute(() -> {
            System.out.println(googlePhotosAutoUploader.getPhotosToUpload());
            System.out.println(googlePhoto.getPhotoStorage());
        });
    }
}
