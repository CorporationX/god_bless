package faang.school.godbless.google;

import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        GooglePhotosAutoUploader photosAutoUploader = new GooglePhotosAutoUploader();
        photosAutoUploader.getPhotosToUpload().addAll(Arrays.asList(
                "Some path to photo",
                "Some path to photo",
                "Some path to photo",
                "Some path to photo",
                "Some path to photo",
                "Some path to photo"
        ));
        executor.submit(() -> photosAutoUploader.startAutoUpload());
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
