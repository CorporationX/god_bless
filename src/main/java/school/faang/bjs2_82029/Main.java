package school.faang.bjs2_82029;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader loader = new GooglePhotosAutoUploader(List.of("server/photo1",
                "server/photo2", "server/photo3"));
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
