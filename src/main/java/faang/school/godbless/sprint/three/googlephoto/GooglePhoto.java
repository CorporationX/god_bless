package faang.school.godbless.sprint.three.googlephoto;

import java.util.ArrayList;
import java.util.List;

public class GooglePhoto {
    public static void main(String... args) {
        List<String> newPhotos = new ArrayList<>(List.of("photo_5", "photo_6", "photo_7", "photo_8", "photo_9"));
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Thread producer = new Thread(() -> newPhotos.forEach(photo -> {
                        try {
                            Thread.sleep(Constants.PRODUCE_NEW_PHOTO_INTERVAL);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.printf("Add new photo %s%n", photo);
                        googlePhotosAutoUploader.onNewPhotoAdded(photo);
                    }
            )
        );
        producer.start();

        try {
            googlePhotosAutoUploader.startAutoUpload();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
