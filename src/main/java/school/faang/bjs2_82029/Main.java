package school.faang.bjs2_82029;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> photos = new ArrayList<>();
        photos.add("server/photo1");
        photos.add("server/photo2");
        photos.add("server/photo3");

        GooglePhotosAutoUploader loader = new GooglePhotosAutoUploader(photos);
        Thread autoloadThread = new Thread(() -> {
            try {
                loader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread addPhotoThread = new Thread(() -> loader.onNewPhotoAdded("server/photo4"));

        autoloadThread.start();
        addPhotoThread.start();
    }
}
