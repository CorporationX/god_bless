package faang.school.godbless.multithreading_synchronization.google_photo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhoto googlePhoto = new GooglePhoto();
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(() -> uploader.startAutoUpload(googlePhoto));
        uploader.onNewPhotoAdded("/dog");
        uploader.onNewPhotoAdded("/cat");
        uploader.onNewPhotoAdded("/family");

        Thread.sleep(4000);

        System.out.println(uploader.getPhotosToUpload());
        executor.execute(() -> System.out.println(googlePhoto.getPhotoStorage()));
    }
}
