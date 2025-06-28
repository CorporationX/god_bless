package school.faang.bjs2_82015;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int NUMBER_OF_PHOTO = 100;

    public static void main(String[] args) {
        List<String> photosToUpload = new ArrayList<>();

        for (int i = 1; i <= NUMBER_OF_PHOTO; i++) {
            photosToUpload.add(String.format("photo%s.png", i));
        }

        GooglePhotosAutoUpload googlePhotosAutoUpload = new GooglePhotosAutoUpload();

        Thread uploadThread = new Thread(googlePhotosAutoUpload::startAutoUpload);
        Thread addPhotoThread = new Thread(() -> photosToUpload.forEach(googlePhotosAutoUpload::onNewPhotoAdded));

        uploadThread.start();
        addPhotoThread.start();
    }
}