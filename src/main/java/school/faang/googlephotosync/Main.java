package school.faang.googlephotosync;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        googlePhotosAutoUploader.onNewPhotoAdded("Anapa2006");

        Random rand = new Random();
        Thread autoUploadThread = new Thread(googlePhotosAutoUploader::startAutoUpload);
        autoUploadThread.setDaemon(true);
        autoUploadThread.start();
        for (int i = 0; i < 10; i++) {
            String photo = "photo#" + rand.nextInt(100);
            new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded(photo)).start();
        }
    }
}
