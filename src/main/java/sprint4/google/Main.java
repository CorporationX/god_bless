package sprint4.google;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final GooglePhotosAutoUploader GOOGLE_PHOTOS = new GooglePhotosAutoUploader();
    private static final int NUMBER_OF_PHOTOS = 10;
    private static final Runnable PHOTO_ADDITION = () -> {
        for (int i = 1; i <= NUMBER_OF_PHOTOS; i++) {
            GOOGLE_PHOTOS.onNewPhotoAdded("/photos/" + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    };

    static {
        GOOGLE_PHOTOS.onNewPhotosAdded(List.of(
                "/photos/aa", "/photos/abs", "/photos/blackbeer", "/photos/mycat", "/photos/dungeonmaster"
        ));
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(GOOGLE_PHOTOS::startAutoUpload);
        service.execute(PHOTO_ADDITION);
        service.shutdown();

        try {
            Thread.sleep(1000);
            GOOGLE_PHOTOS.disableUploader();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
