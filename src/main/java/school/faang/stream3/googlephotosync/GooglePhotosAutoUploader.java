package school.faang.stream3.googlephotosync;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    @Getter
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        log.info("autoupload started");
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                log.info("nothing to upload, waiting");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    log.error("AutoUpload thread interrupted during wait stage");
                }
                if (Thread.currentThread().isInterrupted()) {
                    log.info("AutoUpload thread terminating its work");
                    return;
                }
            }
            log.info("AutoUploader: photos appeared to upload");
            uploadPhotos(photosToUpload);
            startAutoUpload();
        }
    }

    private void uploadPhotos(List<String> currentUploadList) {
        currentUploadList.forEach(UploadService::sendToCloud);
        synchronized (lock) {
            photosToUpload.removeAll(currentUploadList);
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        log.info(String.format("new photo appeared, adding it to uploadList %s", photoPath));
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info(String.format("%s added to upload list", photoPath));
            lock.notify();
        }
    }

    public void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log.error("interruption during delay");
        }
    }
}
