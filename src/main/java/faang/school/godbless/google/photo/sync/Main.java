package faang.school.godbless.google.photo.sync;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        List<String> wait = List.of("aaaa", "bbbb", "cccc");
        startAutoUpload(wait,googlePhotosAutoUploader);
        Thread.sleep(5000);
        System.out.println(googlePhotosAutoUploader.getPhotosToUpload());
        System.out.println(googlePhotosAutoUploader.getPhotosToServer());
    }

    public static void startAutoUpload(List<String> wait, GooglePhotosAutoUploader googlePhotosAutoUploader) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (String string : wait) {
            executorService.submit(googlePhotosAutoUploader::startAutoUpload);
            executorService.submit(() -> googlePhotosAutoUploader.onNewPhotoAdded(string));
        }
        executorService.shutdown();
    }
}