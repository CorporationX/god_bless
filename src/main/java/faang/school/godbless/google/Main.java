package faang.school.godbless.google;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUMS_THREAD_FOR_UPDATE_MESSAGE = 2;
    private static final int NUMS_THREAD_FOR_SEND_MESSAGE = 2;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(NUMS_THREAD_FOR_UPDATE_MESSAGE);
        GooglePhotosAutoUploader photosAutoUploader = new GooglePhotosAutoUploader();
        photosAutoUploader.getPhotosToUpload().addAll(Arrays.asList(
                "Some path to photo",
                "Some path to photo",
                "Some path to photo",
                "Some path to photo",
                "Some path to photo",
                "Some path to photo"
        ));
        int quantityEmails = photosAutoUploader.getPhotosToUpload().size() / NUMS_THREAD_FOR_UPDATE_MESSAGE;
        for(int i = 0; i < NUMS_THREAD_FOR_UPDATE_MESSAGE; i++) {
            List<String> emails = photosAutoUploader.getPhotosToUpload().subList(
                    i * quantityEmails, ((i + 1)*quantityEmails) - 1);
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
