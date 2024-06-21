package faang.school.godbless.google_photo_sync;

import java.util.List;

public class GooglePhotoLoaderService {
    public static void main(String[] args) {
        GooglePhotosAutoUploader photosAutoUploader = new GooglePhotosAutoUploader();
        List<String> photos = List.of("My photo", "Some photo", "Another photo", "New");

        Thread thread1 = new Thread(() -> {
            try {
                photosAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException("Auto uploading failed: " + e.getMessage());
            }
        });

        Thread thread2 = new Thread(() -> {
            for (String photo : photos) {
                photosAutoUploader.onNewPhotoAdded(photo);
            }
        });

        thread1.start();
        thread2.start();

    }
}
