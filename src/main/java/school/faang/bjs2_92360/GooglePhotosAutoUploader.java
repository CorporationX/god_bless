package school.faang.bjs2_92360;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.ArrayList;

@Slf4j
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();

    public synchronized void startAutoUpload() {
        while (true) {
            while (photosToUpload.isEmpty()) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    log.info("ожидалось наполнение списка, но поток был прерван в процессе");
                    Thread.currentThread().interrupt();
                }
            }
            uploadPhotos();
        }
    }

    public synchronized void onNewPhotoAdded(String photoPath) {
        photosToUpload.add(photoPath);
        this.notify();
    }

    private void uploadPhotos() {
        System.out.println("все фотографии из папки загружены на сервер Google.");
        for (String photoPath : photosToUpload) {
            System.out.println(photoPath);
        }
        photosToUpload.clear();
    }
}
