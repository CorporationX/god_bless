package school.faang.sprint3.google;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader google = new GooglePhotosAutoUploader();

        List<String> newPhotos = List.of(".Photo1", ".Photo2", ".Photo3");
        Thread t1 = new Thread(google::startAutoUpload);
        Thread t2 = new Thread(() -> google.onNewPhotoAdded(newPhotos));
        Thread t3 = new Thread(() -> google.onNewPhotoAdded(newPhotos));

        t1.start();
        t2.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        t3.start();
    }
}
