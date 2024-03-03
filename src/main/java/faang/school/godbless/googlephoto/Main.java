package faang.school.godbless.googlephoto;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        GooglePhoto googlePhoto = new GooglePhoto();
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(() -> googlePhotosAutoUploader.startAutoUpload(googlePhoto));

        googlePhotosAutoUploader.onNewPhotoAdded("..\\Pictures-1.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("..\\Pictures-2.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("..\\Pictures-3.jpg");

        System.out.println("List of new photos: " + googlePhotosAutoUploader.getPhotosToUpload());
        executor.execute(() -> System.out.println(googlePhoto.getPhotoStorage()));
    }
}
