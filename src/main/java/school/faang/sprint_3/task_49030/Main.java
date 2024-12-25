package school.faang.sprint_3.task_49030;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload);
        uploadThread.start();

        Thread photoAdderThread = new Thread(() -> {
            List.of("photo1.jpg", "photo2.jpg", "photo3.jpg").forEach(uploader::onNewPhotoAdded);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            uploader.stop();
        });
        photoAdderThread.start();

        try {
            uploadThread.join();
            photoAdderThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Главный поток был прерван.");
        }

        System.out.println("Программа завершена.");
    }
}
