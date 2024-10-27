package faang.school.godbless.google_photo_sync;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googleUploader = new GooglePhotosAutoUploader();
        Thread t1 = new Thread(googleUploader::startAutoUpload, "UPLOADER");
        Thread t2 = new Thread(() -> {
            List<String> photos = Stream.of(1, 2, 3, 4, 5)
                    .map(i -> "Photo_" + i)
                    .toList();
            photos.forEach(photo -> {
                try {
                    googleUploader.onNewPhotoAdded(photo);
                    Thread.sleep(2_000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }, "VIEWER");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
