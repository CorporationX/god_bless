package faang.school.godbless.synchronizationWaitNotify.googlePhotoSync;

import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotos = new GooglePhotosAutoUploader();
        List<String> photoList = IntStream.rangeClosed(1, 20).boxed().map(number -> "image №" + number).toList();

        Thread upload = new Thread(googlePhotos::startAutoUpload);
        Thread add = new Thread(() -> photoList.forEach(googlePhotos::onNewPhotoAdded));

        upload.start();
        add.start();

        try {
            Thread.sleep(1000);

            googlePhotos.stopUploading();
            upload.join();
            add.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
