package faang.school.godbless.BJS2_24516;

import java.util.ArrayList;
import java.util.List;

public class GooglePhoto {
    public static void main(String[] args) {
        var photos = new ArrayList<>(List.of(
                "Camping", "Holiday", "Beach"
        ));
        var uploader = new GooglePhotosAutoUploader(photos);
        var thread1 = new Thread(uploader::startAutoUpload);
        var thread2 = new Thread(() -> {
            int i = 0;
            while (true) {
                try {
                    Thread.sleep(5000);
                    uploader.onNewPhotoAdded("photo" + ++i);
                    uploader.onNewPhotoAdded("photo" + ++i);
                    uploader.onNewPhotoAdded("photo" + ++i);
                    uploader.onNewPhotoAdded("photo" + ++i);
                    uploader.onNewPhotoAdded("photo" + ++i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
