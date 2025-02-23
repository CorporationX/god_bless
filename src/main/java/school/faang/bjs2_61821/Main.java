package school.faang.bjs2_61821;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<String> photos = Arrays.asList("a.jpg", "b.jpg", "c.jpg", "d.jpg");

        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader(photos);
        Thread thread1 = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    uploader.startAutoUpload();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                uploader.onNewPhotoAdded(i + ".jpg");
            }
        });

        thread1.start();
        thread2.start();
    }
}
