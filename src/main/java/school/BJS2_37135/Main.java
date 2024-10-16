package school.BJS2_37135;

import java.util.Arrays;

public class Main {

    private static String[] pathToFile = {"photo_1.jpg", "photo_2.jpg", "photo_3.jpg", "photo_4.jpg", "photo_5.jpg", "photo_6.jpg", "photo_7.jpg"};

    public static void main(String[] args) {

        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread thread1 = new Thread(() -> {
            Arrays.stream(pathToFile).forEach(path -> googlePhotosAutoUploader.onNewPhotoAdded(path));
        });
        Thread thread2 = new Thread(() -> {
            try {
                googlePhotosAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

    }
}