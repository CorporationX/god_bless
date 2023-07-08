package faang.school.godbless.multithreading.google_photo;

import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        List<String> photosToUploadOne = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> "photo-" + i)
                .toList();

        List<String> photosToUploadTwo = IntStream.rangeClosed(11, 20)
                .mapToObj(i -> "photo-" + i)
                .toList();

        Thread uploaderThread = new Thread(uploader::startAutoUpload, "uploaderThread");
        Thread adderThreadOne = new Thread(
                () -> photosToUploadOne.forEach(uploader::onNewPhotoAdded), "adderThread-1");
        Thread adderThreadTwo = new Thread(
                () -> photosToUploadTwo.forEach(uploader::onNewPhotoAdded), "adderThread-2");

        uploaderThread.start();
        adderThreadOne.start();
        adderThreadTwo.start();

        Thread.sleep(3000);

        uploader.stop();

        uploader.getGooglePhotos().forEach(System.out::println);
    }
}
