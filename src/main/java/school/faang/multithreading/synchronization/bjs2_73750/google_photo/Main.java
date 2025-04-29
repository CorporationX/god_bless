package school.faang.multithreading.synchronization.bjs2_73750.google_photo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader(7000);
        Thread autoUploadThread = new Thread(uploader::startAutoUpload);
        Thread photoAdditionThread = new Thread(() -> {
            uploader.onNewPhotoAdded("C:\\DATA\\images\\1.jpg");
            uploader.onNewPhotoAdded("C:\\DATA\\images\\2.jpg");
            uploader.onNewPhotoAdded("C:\\DATA\\images\\3.jpg");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                Thread.currentThread().interrupt();
            }
            uploader.onNewPhotoAdded("C:\\DATA\\images\\4.jpg");
            uploader.onNewPhotoAdded("C:\\DATA\\images\\5.jpg");
        });

        Thread photoAdditionThread2 = new Thread(() -> {
            uploader.onNewPhotoAdded("C:\\DATA\\images\\6.jpg");
            uploader.onNewPhotoAdded("C:\\DATA\\images\\7.jpg");
        });
        autoUploadThread.start();
        photoAdditionThread.start();
        photoAdditionThread2.start();
    }
}
