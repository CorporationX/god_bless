package faang.school.godbless.BJS2_5532;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object LOCK = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (LOCK) {
            while (true) {
                while (photosToUpload.isEmpty()) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void uploadPhotos() {
        photosToUpload.forEach(str -> System.out.println("Отправлена фотография: " + str));
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(List<String> photoPath) {
        synchronized (LOCK) {
            photosToUpload.addAll(photoPath);
            LOCK.notify();
        }
    }
}
