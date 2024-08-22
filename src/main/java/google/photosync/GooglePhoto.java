package google.photosync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhoto {
    public static void main(String[] args) {
        GooglePhotoAutoUploader photoAutoUploader = new GooglePhotoAutoUploader(new Object(),
                new ArrayList<>(List.of("1.jpg", "1321.jpg", "aboba.jpg", "boba.jpg",
                        "biba.jpg", "afasf.jpg", "DCIM10034,jpg", "test.jpg")));
        Thread autoUploadThread = new Thread(photoAutoUploader::startAutoUpload);
        Thread addingPhotoToUploadThread = new Thread(() -> {
            try {
                photoAutoUploader.onNewPhotoAdded("zaza.jpg");
                Thread.sleep(1000);
                photoAutoUploader.onNewPhotoAdded("asfzxv.jpg");
                Thread.sleep(500);
                photoAutoUploader.onNewPhotoAdded("gaga.jpg");
                photoAutoUploader.stopService();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        autoUploadThread.start();
        addingPhotoToUploadThread.start();
    }
}
