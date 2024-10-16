package bjs2_37177;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<String> photos = List.of("photo1", "photo2", "photo3");
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader(photos);

        new Thread(() -> {
            try {
                uploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();


        new Thread(() -> uploader.onNewPhotoAdded("photo4")).start();
        Thread.sleep(3000);
        new Thread(() -> uploader.onNewPhotoAdded("photo5")).start();

    }
}
