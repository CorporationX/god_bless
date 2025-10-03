package school.faang.bjs2_90487;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GooglePhotosAutoUploader {
    private static final int THREAD_SLEEP = 1000;
    private final List<String> photosToUpload = Collections.synchronizedList(new ArrayList<>());

    public synchronized void startAutoUpload() throws InterruptedException {
        while (photosToUpload.isEmpty()) {
            wait();
        }
        uploadPhotos();
    }

    public synchronized void onNewPhotoAdded(String photoPath) {
        photosToUpload.add(photoPath);
        notify();
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
