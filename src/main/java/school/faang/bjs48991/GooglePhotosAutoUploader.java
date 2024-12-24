package school.faang.bjs48991;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload;

    public GooglePhotosAutoUploader() {
        photosToUpload = new ArrayList<>();
    }

    public void startAutoUpload() throws InterruptedException {
        while (true) {
            synchronized (photosToUpload) {
                if (photosToUpload.isEmpty()) {
                    photosToUpload.wait();
                    log.info("Waiting because no photos");
                }
            }
            log.info("Been notified or there was photos");
            uploadPhotos();
        }
    }

    public void uploadPhotos() {
        synchronized (photosToUpload) {
            photosToUpload.forEach(photo -> log.info("Photo {} delivered to server", photo));
            photosToUpload.clear();
        }
    }

    public void onNewPhotoAdded(String path) {
        synchronized (photosToUpload) {
            photosToUpload.add(path);
            photosToUpload.notify();
            log.info("Added photo {} and notified", path);
        }
    }
}
