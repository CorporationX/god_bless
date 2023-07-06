package faang.school.godbless.sprint4.multithreading_synchronization_wait_notify.task4;

import java.util.ArrayList;
import java.util.List;

public class GooglePhoto {

    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        List<Thread> threads = new ArrayList<>();

        Thread thread1 = new Thread(() -> {
            googlePhotosAutoUploader.onNewPhotoAdded("photo1");
        });
        Thread thread2 = new Thread(googlePhotosAutoUploader::startAutoUpload);
        threads.add(thread2);
        threads.add(thread1);

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
