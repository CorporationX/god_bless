package faang.school.godbless.google;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    @Getter
    private List<String> photosToUpload = new ArrayList<>();
    @Setter
    private boolean offTurn = true;

    @SneakyThrows
    public void startAutoUpload() {
        synchronized (lock) {
            while (offTurn) {
                if (photosToUpload.size() == 0) {
                    lock.wait(3000);
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        System.out.println("Photo send to Google");
        photosToUpload.remove(0);
    }
}
