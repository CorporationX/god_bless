package school.faang.BJS2_61713;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class GooglePhotosAutoUploader {
    public static final String SOMETHING_WENT_WRONG = "Something went wrong.";
    public static final String NEW_PHOTO_TO_UPLOAD = "There is a new photo to upload.";
    public static final String UPLOAD_IS_OVER = "The photo upload is over.";
    public static final String UPLOADING_PHOTO = "Uploading photo: {}";
    public static final String EXECUTING_UPLOAD_PHOTOS = "Executing upload photos.";
    public static final String FILE_NAME_CANNOT_BE_NULL = "File name cannot be null";
    public static final int UPLOAD_TIME = 500;
    private final Object lock = new Object();
    private static final List<Photo> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (photosToUpload.isEmpty()) {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    log.error(SOMETHING_WENT_WRONG);
                    throw new RuntimeException(e);
                }
            }
            uploadPhotos();
        }
    }

    private void uploadPhotos() {
        synchronized (lock) {
            log.info(EXECUTING_UPLOAD_PHOTOS);
            for (Photo photo : photosToUpload) {
                log.info(UPLOADING_PHOTO, photo.getName());
                try {
                    Thread.sleep(UPLOAD_TIME);
                } catch (InterruptedException e) {
                    log.error(SOMETHING_WENT_WRONG);
                    throw new RuntimeException(e);
                }
            }
            photosToUpload.clear();
            log.info(UPLOAD_IS_OVER);
            lock.notify();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        Objects.requireNonNull(photoPath, FILE_NAME_CANNOT_BE_NULL);
        if (!photoPath.isBlank()) {
            synchronized (lock) {
                photosToUpload.add(new Photo(photoPath));
                log.info(NEW_PHOTO_TO_UPLOAD);
                lock.notify();
            }
        }
    }
}
