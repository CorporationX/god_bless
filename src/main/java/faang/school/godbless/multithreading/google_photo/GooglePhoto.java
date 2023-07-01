package faang.school.godbless.multithreading.google_photo;

import java.util.List;
import java.util.stream.IntStream;

public class GooglePhoto {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();
        List<String> photos = IntStream.range(1, 11).boxed().map(i -> i + "photo").toList();
        Thread upload = new Thread(() -> autoUploader.startAutoUpload());
        Thread add = new Thread(() -> photos.forEach(autoUploader::onNewPhotoAdded));

        upload.start();
        add.start();
        Thread.sleep(1000); // Чтобы фото успели загрузиться
        autoUploader.stopAutoUpload();
        upload.join();
        add.join();
    }
}
