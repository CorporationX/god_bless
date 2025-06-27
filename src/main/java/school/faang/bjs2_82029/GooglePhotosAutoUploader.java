package school.faang.bjs2_82029;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload;

    public GooglePhotosAutoUploader(List<String> photosToUpload) {
        this.photosToUpload = photosToUpload;
    }

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

    public void uploadPhotos() {
        synchronized (lock) {
            Iterator<String> iterator = photosToUpload.iterator();
            while (iterator.hasNext()) {
                log.info("Uploading {}...", iterator.next());
                iterator.remove();
            }
        }
    }
}
