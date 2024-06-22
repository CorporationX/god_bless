package faang.school.godbless.multithreading.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader gu = new GooglePhotosAutoUploader();

        List<Photo> photos = new ArrayList<>(Arrays.asList(
                new Photo("photo1"),
                new Photo("photo2"),
                new Photo("photo3"),
                new Photo("photo4"),
                new Photo("photo5"),
                new Photo("photo6"),
                new Photo("photo7"),
                new Photo("photo8"),
                new Photo("photo9"),
                new Photo("photo10")));


        var threadPool = Executors.newFixedThreadPool(2);

        threadPool.submit(gu::startAutoUpload);
        for (Photo photo : photos) {
            threadPool.submit(() -> gu.onNewPhotoAdded(photo));
        }

        threadPool.shutdown();
        threadPool.awaitTermination(20, TimeUnit.SECONDS);
    }
}
