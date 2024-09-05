package faang.school.godbless.BJS2_24482;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();
        Thread thUploadPhoto = new Thread(googlePhoto::startAutoUpload);
        Thread thAddPhoto = new Thread(() -> {
            while (true) {
                try {
                    googlePhoto.onNewPhotoAdded("somephoto_" + rand.nextInt(1, 1000));
                    Thread.sleep(1000, rand.nextInt(2000, 5000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thUploadPhoto.start();
        thAddPhoto.start();
    }
}
