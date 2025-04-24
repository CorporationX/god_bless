package school.faang.photos;

import lombok.extern.slf4j.Slf4j;
import school.WaitUtils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {

    private static final long PHOTO_DOWNLOAD_TIME_MILLIS = 300;

    private final Deque<String> photos = new ArrayDeque<>();
    private boolean autoUpdateOn;

    public void startAutoUpload() {
        autoUpdateOn = true;
        log.info("starts auto update");
        while (autoUpdateOn) {
            uploadPhoto();
        }
    }

    public void uploadPhoto() {
        String pathToPhoto;
        synchronized (photos) {
            if (photos.isEmpty()) {
                photos.notify();
                log.info("autoloader waiting new photos");
                WaitUtils.threadWait(photos);
                if (!autoUpdateOn) {
                    log.info("auto uploader finish working");
                    return;
                }
                log.info("continue uploading");
            }
            pathToPhoto = photos.pop();
        }
        log.info("uploading {} start", pathToPhoto);
        WaitUtils.sleep(PHOTO_DOWNLOAD_TIME_MILLIS);
        log.info("uploading {} finished", pathToPhoto);
    }

    public void onNewPhotoAdded(String... photoPath) {
        synchronized (photos) {
            photos.addAll(List.of(photoPath));
            log.info("added {} new photos", photoPath.length);
            photos.notify();
        }
    }

    public void turnOffAutoUpdate() {
        synchronized (photos) {
            if (!photos.isEmpty()) {
                WaitUtils.threadWait(photos);
            }
            autoUpdateOn = false;
            photos.notify();
        }
    }
}
