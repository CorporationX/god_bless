package school.faang.GooglePhoto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        ExecutorService service = Executors.newFixedThreadPool(5);

        List<String> images1 = new ArrayList<>(List.of("Image 1", "Image 2", "Image 3", "Image 4", "Image 5"));
        List<String> images2 = new ArrayList<>(List.of("Image 6", "Image 7", "Image 8", "Image 9", "Image 10"));


        service.execute(() -> images1.forEach(googlePhotosAutoUploader::onNewPhotoAdded));
        service.execute(googlePhotosAutoUploader::startAutoUpload);
        service.execute(() -> images2.forEach(googlePhotosAutoUploader::onNewPhotoAdded));

        service.shutdown();

        try {
            if (!service.awaitTermination(10, TimeUnit.SECONDS)){
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Something went wrong", e);
        }


    }
}
