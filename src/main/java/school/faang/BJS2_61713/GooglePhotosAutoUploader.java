package school.faang.BJS2_61713;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class GooglePhotosAutoUploader {
    private static final int UPLOAD_TIME = 500;
    private final Object lock = new Object();
    private final List<Photo> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (photosToUpload.isEmpty()) {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    interruptedExceptionHandler(e);
                }
            }
            uploadPhotos();
        }
    }

    private void uploadPhotos() {
        synchronized (lock) {
            log.info(AutoUploaderMasseges.EXECUTING_UPLOAD_PHOTOS);
            for (Photo photo : photosToUpload) {
                log.info(AutoUploaderMasseges.UPLOADING_PHOTO, photo.getName());
                try {
                    Thread.sleep(UPLOAD_TIME);
                } catch (InterruptedException e) {
                    interruptedExceptionHandler(e);
                }
            }
            photosToUpload.clear();
            log.info(AutoUploaderMasseges.UPLOAD_IS_OVER);
            lock.notifyAll();
        }
    }

    private static void interruptedExceptionHandler(InterruptedException e) {
        log.error(AutoUploaderMasseges.SOMETHING_WENT_WRONG);
        Thread.currentThread().interrupt();
        throw new RuntimeException(e);
    }

    public void onNewPhotoAdded(String photoPath) {
        Objects.requireNonNull(photoPath, AutoUploaderMasseges.FILE_NAME_CANNOT_BE_NULL);
        if (!photoPath.isBlank()) {
            synchronized (lock) {
                photosToUpload.add(new Photo(photoPath));
                log.info(AutoUploaderMasseges.NEW_PHOTO_TO_UPLOAD);
                lock.notify();
            }
        }
    }
}
