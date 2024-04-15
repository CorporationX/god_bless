package faang.school.godbless.BJS2_5532;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    @SneakyThrows
    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                lock.wait();
            }
            uploadPhotos();
        }
    }

    public void uploadPhotos() {
        photosToUpload.forEach(str -> System.out.println("Отправлена фотография: " + str));
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(List<String> photoPath) {
        synchronized (lock) {
            photosToUpload.addAll(photoPath);
            lock.notify();

        }
    }
}
