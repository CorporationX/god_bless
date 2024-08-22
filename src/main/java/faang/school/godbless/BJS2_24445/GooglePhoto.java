package faang.school.godbless.BJS2_24445;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class GooglePhoto {
    public static void main(String[] args) {
        String photoPathOne = "/Users/Username/Pictures/image1.jpg";
        String photoPathTwo = "/home/username/Pictures/image2.jpg";
        String photoPathThree = "/Photos/Vacation/2023/beach_sunset.jpg";
        String photoPathFour = "Work/Projects/Designs/logo_concept.jpg";
        String photoPathFive = "/mnt/data/images/gallery/photo_of_the_day.jpg";

        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        uploader.getPhotoPaths().add(photoPathOne);
        uploader.getPhotoPaths().add(photoPathTwo);

        Runnable user = () -> {
            uploader.onNewPhotoAdded(photoPathThree);
            uploader.onNewPhotoAdded(photoPathFour);
            uploader.onNewPhotoAdded(photoPathFive);
        };

        Runnable cloud = uploader::startAutoUpdate;

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(cloud);
        executorService.execute(user);
        executorService.shutdown();
    }


}
