package faang.school.godbless.modul3.photosync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int N_TREADS = 2;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(N_TREADS);

        List<String> photoPathsPack = new ArrayList<>(
                List.of("/src/recourse/Photo 1.png",
                        "/src/recourse/Photo 2.png",
                        "/src/recourse/Photo 3.png")
        );
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader(new Object(), photoPathsPack);
        executorService.submit(autoUploader::startAutoUpload);

        String newPhotoPath1 = "/src/recourse/forest.png";
        executorService.submit(() -> autoUploader.onNewPhotoAdded(newPhotoPath1));
        String newPhotoPath2 = "/src/recourse/beach.png";
        executorService.submit(() -> autoUploader.onNewPhotoAdded(newPhotoPath2));
        String newPhotoPath3 = "/src/recourse/village.png";
        executorService.submit(() -> autoUploader.onNewPhotoAdded(newPhotoPath3));

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("All task complete!");
            } else {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}