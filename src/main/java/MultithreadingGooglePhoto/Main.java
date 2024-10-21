package MultithreadingGooglePhoto;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> photos = new ArrayList<>();
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader(photos);
        Thread photoUploadThread = new Thread(() -> {
            try {
                uploader.startAutoUpload();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread photoAddThread = new Thread(() -> {
            uploader.onNewPhotoAdded("C:/Users/photos/" + System.currentTimeMillis() + ".png");
            uploader.onNewPhotoAdded("C:/Users/photos/" + System.currentTimeMillis() + ".png");
        });

        photoUploadThread.start();
        photoAddThread.start();
    }
}
