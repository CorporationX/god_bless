package faang.school.godbless.googlePhoto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String... args) throws InterruptedException {
        List<String> photos = List.of("somePhoto", "oldPhoto", "justPhoto");
        List<String> photosToUpload = new ArrayList<>();
        photosToUpload.add("photo1");
        photosToUpload.add("photo2");
        photosToUpload.add("photo3");
        photosToUpload.add("photo4");
        GooglePhoto googlePhoto = new GooglePhoto(photos);
        Thread uploadPhoto = new Thread(() -> googlePhoto.uploadPhoto(photosToUpload));
        Thread viewPhoto = new Thread(() -> googlePhoto.getPhotos().forEach(System.out::println));
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(() -> uploadPhoto.run());
        executor.execute(() -> viewPhoto.run());
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
    }
}
