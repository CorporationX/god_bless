package GooglePhotoSync;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static GooglePhotosAutoUploader googlePhotos = new GooglePhotosAutoUploader();
    private static String pathToNewPhotos = "C:\\...";
    private static final int AMOUNT_THREAD = 2;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(AMOUNT_THREAD);
        executorService.execute(googlePhotos::startAutoUpload);
        executorService.execute(() -> googlePhotos.onNewPhotoAdded(pathToNewPhotos));
        executorService.shutdown();
    }
}
