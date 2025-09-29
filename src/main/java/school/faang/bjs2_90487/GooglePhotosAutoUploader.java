package school.faang.bjs2_90487;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GooglePhotosAutoUploader {
    private static final int THREAD_SLEEP = 1000;
    private final Object lock = new Object();
    private final List<String> photosToUpload = Collections.synchronizedList(new ArrayList<>());

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                lock.wait();
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() throws InterruptedException {
        for (String photo : photosToUpload) {
            System.out.println("Загружаем фотографию: " + photo);
            Thread.sleep(THREAD_SLEEP);
            System.out.println(photo + " успешно загружено");
        }
        photosToUpload.clear();
    }
}
