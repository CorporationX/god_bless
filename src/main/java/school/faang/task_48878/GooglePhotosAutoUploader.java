package school.faang.task_48878;

import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object object = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    @SneakyThrows
    public void startAutoUpload() {
        while (true) {
            synchronized (object) {
                if (photosToUpload.isEmpty()) {
                    object.wait();
                    log.info("Wait upload new photos...");
                }
                uploadPhotos(photosToUpload);
            }
        }
    }

    @SneakyThrows
    private void uploadPhotos(@NonNull List<String> photos) {
        log.info("Upload photos to server: {}", photos);
        Thread.sleep(1000);
        photosToUpload.removeAll(photos);
        log.info("Photos uploaded. Storage count = {}", photosToUpload.size());
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (object) {
            photosToUpload.add(photoPath);
            log.info("New photo added: {}", photoPath);
            object.notify();
        }
    }
}
