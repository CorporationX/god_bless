package faang.school.godbless.google_photo_sync;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        List<String> photoPaths = List.of("path A", "path B", "path C", "path D", "path E");

        for (String photoPath : photoPaths) {
            Thread uploaderThread = new Thread(() -> {
                try {
                    googlePhotosAutoUploader.startAutoUpload();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            Thread viewingThread = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded(photoPath));

            uploaderThread.start();
            viewingThread.start();
        }
    }
}
