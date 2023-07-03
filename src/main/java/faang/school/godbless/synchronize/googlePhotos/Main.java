package faang.school.godbless.synchronize.googlePhotos;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<String> photosToUpload = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            photosToUpload.add("test-path" + i + ".jpg");
        }

        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(() -> {
            try {
                googlePhotosAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread viewThread = new Thread(() -> {
            for (String s : photosToUpload) {
                googlePhotosAutoUploader.onNewPhotoAdded(s);
            }
        });

        uploadThread.start();
        viewThread.start();
        uploadThread.join();
        viewThread.join();
    }
}
