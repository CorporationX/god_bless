package google_photo_sync;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GooglePhoto {

    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Random random = new Random();
        Thread uploadThread = new Thread(googlePhotosAutoUploader::startUploadPhoto);
        Thread addPhotosThread = new Thread(() -> {
            while (true) {
                try {
                    int photosCount = random.nextInt(1,10);
                    List<String> photosToUpload = new ArrayList<>();
                    for (int i = 0; i < photosCount; i++) {
                        photosToUpload.add("%d.jpg".formatted(i));
                    }
                    googlePhotosAutoUploader.onNewPhotosAdded(photosToUpload);
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        uploadThread.start();
        addPhotosThread.start();
    }
}
