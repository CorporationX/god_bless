package google.photo.sync;

import java.util.Arrays;
import java.util.List;

public class Main {
    private final static int CHECK_UPLOAD_PHOTO_DEAL = 1000;

    public static void main(String[] args) throws InterruptedException {
        List<GooglePhoto> photos = Arrays.asList(
            new GooglePhoto("1.jpg"),
            new GooglePhoto("2.jpg"),
            new GooglePhoto("3.jpg"),
            new GooglePhoto("4.jpg"),
            new GooglePhoto("5.jpg"),
            new GooglePhoto("6.jpg"),
            new GooglePhoto("7.jpg"),
            new GooglePhoto("8.jpg"),
            new GooglePhoto("9.jpg"),
            new GooglePhoto("10.jpg")
        );

        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();


        Thread autouploadThread = new Thread(() -> {
            try {
                uploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        Thread uploadPhotoThread = new Thread(() -> {
            photos.forEach(photo -> {
                try {
                    uploader.onNewPhotoAdded(photo);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        });

        autouploadThread.start();
        uploadPhotoThread.start();

        uploadPhotoThread.join();

        while (!uploader.getPhotosToUpload().isEmpty()) {
            Thread.sleep(CHECK_UPLOAD_PHOTO_DEAL);
        }

        try {
            uploadPhotoThread.join();
            System.out.println("Все фото загружены");
            autouploadThread.interrupt();
        } catch (InterruptedException ignored) {}
    }
}
