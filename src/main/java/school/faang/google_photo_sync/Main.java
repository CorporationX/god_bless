package school.faang.google_photo_sync;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader(new ArrayList<>());

        Thread addThread = new Thread(() -> {
            autoUploader.onNewPhotoAdded("Photo1");
            autoUploader.onNewPhotoAdded("Photo2");
            autoUploader.onNewPhotoAdded("Photo3");
        });
        Thread loadThread = new Thread(() -> {
            try {
                autoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        loadThread.start();
        addThread.start();
    }
}
