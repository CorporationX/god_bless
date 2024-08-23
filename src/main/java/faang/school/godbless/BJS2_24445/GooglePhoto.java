package faang.school.godbless.BJS2_24445;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GooglePhoto {
    public static void main(String[] args) {
        String photoPathOne = "/Users/Username/Pictures/image1.jpg";
        String photoPathTwo = "/home/username/Pictures/image2.jpg";
        String photoPathThree = "/Photos/Vacation/2023/beach_sunset.jpg";
        String photoPathFour = "Work/Projects/Designs/logo_concept.jpg";
        String photoPathFive = "/mnt/data/images/gallery/photo_of_the_day.jpg";

        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Runnable user = () -> {
            sleepWithCatchException(1000);
            uploader.onNewPhotoAdded(photoPathOne);
            sleepWithCatchException(1000);
            uploader.onNewPhotoAdded(photoPathTwo);
            sleepWithCatchException(1000);
            uploader.onNewPhotoAdded(photoPathThree);
            sleepWithCatchException(1000);
            uploader.onNewPhotoAdded(photoPathFour);
            sleepWithCatchException(1000);
            uploader.onNewPhotoAdded(photoPathFive);
        };

        Runnable cloud = () -> {
            sleepWithCatchException(2000);
            uploader.startAutoUpdate();
            sleepWithCatchException(2000);
            uploader.startAutoUpdate();
            sleepWithCatchException(2000);
            uploader.startAutoUpdate();
        };

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(cloud);
        executor.execute(user);
        executor.shutdown();
    }

    private static void sleepWithCatchException(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread error");
        }
    }
}
