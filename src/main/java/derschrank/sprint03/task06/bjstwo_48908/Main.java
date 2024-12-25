package derschrank.sprint03.task06.bjstwo_48908;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int CONT_OF_FOTOS_TO_UPLOAD = 100;

    public static void main(String[] args) {
        GooglePhotosAutoUploaderInterface uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(() -> uploader.startAutoUpload());
        uploadThread.start();

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < CONT_OF_FOTOS_TO_UPLOAD; i++) {
            String pathPhoto = "photo" + (1000 + i) + ".jpg";
            executor.execute(
                () -> uploader.onNewPhotoAdded(pathPhoto)
            );
        }

        executor.shutdown();
        try {
            executor.awaitTermination(2, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.out.println("Main was Interrupted");
        }
        uploader.stopAutoUpload();
    }
}
