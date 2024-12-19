package school.faang.task_48903;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread producerThread = new Thread(() -> {
            while (true) {
                uploader.onNewPhotoAdded(UUID.randomUUID().toString());
            }
        });

        Thread consumerThread = new Thread(() -> {
            while (true) {
                uploader.startAutoUpload();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
