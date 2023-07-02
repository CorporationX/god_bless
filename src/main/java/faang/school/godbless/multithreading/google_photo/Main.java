package faang.school.godbless.multithreading.google_photo;

import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        List<String> photosToUpload = IntStream.rangeClosed(1, 20)
                .mapToObj(i -> "photo-" + i)
                .toList();

        Thread uploaderThread = new Thread(uploader::startAutoUpload, "uploaderThread");
        Thread watcherThread = new Thread(() -> photosToUpload.forEach(uploader::onNewPhotoAdded), "watcherThread");

        uploaderThread.start();
        watcherThread.start();

        Thread.sleep(3000);

        uploader.stop();

        uploader.getGooglePhotos().forEach(System.out::println);
    }
}
