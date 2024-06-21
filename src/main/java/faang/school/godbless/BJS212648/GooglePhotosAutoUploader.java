package faang.school.godbless.BJS212648;

import java.util.ArrayList;
import java.util.List;

import static faang.school.godbless.BJS212648.RepeaterUtil.*;

public class GooglePhotosAutoUploader {

    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        final int interval = 10;
        repeat(() -> interval, () -> {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    wait(lock);
                }
                uploadPhotos();
            }
        });
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            String fullPhotoPath = photoPath + photosToUpload.size();
            photosToUpload.add(fullPhotoPath);
            System.out.println("Добавлено фото " + fullPhotoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        System.out.println(String.format("Закгружено фото %s", photosToUpload.size()));
        photosToUpload.clear();
    }

    private void wait(Object lock) {
        try {
            lock.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
