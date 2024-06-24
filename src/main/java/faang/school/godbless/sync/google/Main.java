package faang.school.godbless.sync.google;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        var googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        var photos = List.of("/my_folder/photo1", "/my_folder/photo2", "/my_folder/photo3", "/my_folder/photo4",
                "/my_folder/photo5");

        Thread autoUploadThread = new Thread(googlePhotosAutoUploader::startAutoUpload);
        autoUploadThread.start();

        photos.forEach(path -> {
            Thread thread = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded(path));
            thread.start();
        });

        new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            googlePhotosAutoUploader.stopAutoUpload();
        }).start();
    }
}
