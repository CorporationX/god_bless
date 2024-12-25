package school.faang.task_49134;

import java.util.Set;

public class UploadManager {
    public static final String PHOTO_PATH_1 = "first";
    public static final String PHOTO_PATH_2 = "second";

    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Set<String> photoPaths = Set.of(PHOTO_PATH_1, PHOTO_PATH_2);

        Thread thread1 = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded(PHOTO_PATH_1));
        Thread thread2 = new Thread(() -> googlePhotosAutoUploader.startAutoUpload(photoPaths));

        thread1.start();
        thread2.start();
    }
}
