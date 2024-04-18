package faang.school.godbless.googlephoto;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(googlePhoto::startAutoUpload);
        executor.execute(() -> googlePhoto.onNewPhotoAdded("photo1"));
        executor.execute(() -> googlePhoto.onNewPhotoAdded("photo2"));

        executor.execute(googlePhoto::uploadPhotos);

        executor.shutdown();
    }
}
