package school.faang.task_48960;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        GooglePhotosAutoUploader googleUploader = new GooglePhotosAutoUploader();

        Thread uploaderThread = new Thread(googleUploader::startAutoUpload);
        Thread adderThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                googleUploader.onNewPhotoAdded("C://journey/photo" + i);
            }
        });

        Thread[] threads = new Thread[]{uploaderThread, adderThread};
        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Поток был прерван при выполнении метода join()", e);
                Thread.currentThread().interrupt();
            }
        }
    }
}
