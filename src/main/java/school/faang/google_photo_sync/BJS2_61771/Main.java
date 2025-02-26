package school.faang.google_photo_sync.BJS2_61771;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread photoUploader = new Thread(() -> {
            try {
                uploader.startAutoUpload();
            } catch (InterruptedException e) {
                log.error("Выполнение задачи прервано {}", e.getMessage());
                Thread.currentThread().interrupt();
            }
        });

        Thread photoAdditions = new Thread(() -> {
            uploader.onNewPhotoAdded(
                    "C:\\Users\\Anonymous\\Desktop\\Images\\1MVVN8GB8TZD9852V9BAM1EEE0.jpeg");
        });

        photoAdditions.start();
        photoUploader.start();
    }
}
