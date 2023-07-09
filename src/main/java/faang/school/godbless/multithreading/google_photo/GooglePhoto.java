package faang.school.godbless.multithreading.google_photo;

import java.util.List;
import java.util.stream.IntStream;

public class GooglePhoto {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();
        List<String> photos1 = IntStream.range(1, 11).boxed().map(i -> i + "photo").toList();
        List<String> photos2 = IntStream.range(11, 21).boxed().map(i -> i + "photo").toList();
        List<String> photos3 = IntStream.range(21, 31).boxed().map(i -> i + "photo").toList();
        List<String> photos4 = IntStream.range(31, 41).boxed().map(i -> i + "photo").toList();
        Thread upload = new Thread(autoUploader::startAutoUpload);

        Thread add1 = new Thread(() -> photos1.forEach(autoUploader::onNewPhotoAdded));
        Thread add2 = new Thread(() -> photos2.forEach(autoUploader::onNewPhotoAdded));
        Thread add3 = new Thread(() -> photos3.forEach(autoUploader::onNewPhotoAdded));
        Thread add4 = new Thread(() -> photos4.forEach(autoUploader::onNewPhotoAdded));

        upload.start();
        add1.start();
        add2.start();
        add3.start();
        add4.start();
        Thread.sleep(1000); // Чтобы фото успели загрузиться
        autoUploader.stopAutoUpload();
    }
}
