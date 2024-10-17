package school.faang.googlephotosynchronyzed;

import java.util.ArrayList;
import java.util.List;

public class PhotoManager {
    public static void main(String[] args) {
        List<String> pathsToPhoto = new ArrayList<>();
        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader(new Locker(), pathsToPhoto);
        Thread firstThread = new Thread(() -> {
            try {
                googlePhoto.startAutoUpload();
            } catch (InterruptedException e) {
                throw new IllegalStateException("Не отработал: googlePhoto.startAutoUpload ", e);
            }
        });
        Thread secondThread = new Thread(() -> googlePhoto.onNewPhotoAdded("new path to photo"));
        firstThread.start();
        secondThread.start();
    }
}
