package faang.school.godbless.google_photo_sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        List<GooglePhoto> photos = new ArrayList<>();
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader(photos);

        executor.execute(() -> photos.forEach(System.out::println));
        executor.execute(uploader::startAutoUpload);
        uploader.onNewPhotoAdded(new GooglePhoto("Sveta"));
        uploader.onNewPhotoAdded(new GooglePhoto("Vlad"));

        executor.shutdown();
    }
}
