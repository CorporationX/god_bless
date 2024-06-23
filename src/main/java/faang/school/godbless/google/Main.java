package faang.school.godbless.google;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUMS_THREAD = 10;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(NUMS_THREAD);
        GooglePhotosAutoUploader photosAutoUploader = new GooglePhotosAutoUploader();
        photosAutoUploader.getPhotosToUpload().addAll(Arrays.asList(
                "Some path to photo",
                "Some path to photo",
                "Some path to photo",
                "Some path to photo",
                "Some path to photo",
                "Some path to photo"
        ));
        int totalPhotos = photosAutoUploader.getPhotosToUpload().size();
        int quantityPhotosPerThread = totalPhotos / NUMS_THREAD;
        for (int i = 0; i < NUMS_THREAD; i++) {
            int startIndex = 0;
            int endIndex = Math.min(startIndex + quantityPhotosPerThread, totalPhotos);
            List<String> emails = photosAutoUploader.getPhotosToUpload().subList(startIndex, endIndex);
            executor.submit(() -> photosAutoUploader.startAutoUpload(emails));
        }
        executor.submit(() -> {
            newPhotos().forEach(photosAutoUploader::onNewPhotoAdded);
        });
        Thread.sleep(5000);
        photosAutoUploader.setOffTurn(false);
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Update success finish");
    }

    private static List<String> newPhotos() {
        return Arrays.asList(
                "Some new photo path",
                "Some new photo path",
                "Some new photo path",
                "Some new photo path"
        );
    }
}
