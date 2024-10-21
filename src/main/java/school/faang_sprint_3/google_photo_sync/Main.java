package school.faang_sprint_3.google_photo_sync;

import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        GooglePhotosUploader uploader = new GooglePhotosUploader();

        var threads = Executors.newFixedThreadPool(2);
        threads.submit(uploader::startAutoUpload);
        threads.submit(() -> {
            uploader.addNewPhoto("fist_photo.jpg");
            uploader.addNewPhoto("second_photo.jpg");
        });
        threads.shutdown();
    }
}
