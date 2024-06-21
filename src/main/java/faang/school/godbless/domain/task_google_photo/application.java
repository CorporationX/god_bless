package faang.school.godbless.domain.task_google_photo;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class application {

    public static final String IMAGE_DIR = "C:\\images\\";

    public static final String SPLITTER = "    ";
    public static final int THREAD_COUNT = 2;

    public static void main(String[] args) {
        List<String> photoPaths = List.of(IMAGE_DIR + "read_only.jpeg", IMAGE_DIR + "deadlock.jpeg", IMAGE_DIR + "warp_gate_exploit");
        GooglePhotosAutoUploader updater = new GooglePhotosAutoUploader();

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

        executorService.submit(() -> loadPhotosToMemory(photoPaths, updater));
        executorService.submit(() -> loadPhotosToServer(updater));

        executorService.shutdown();

    }


    private static void loadPhotosToMemory(List<String> photoPaths, GooglePhotosAutoUploader uploader) {
        photoPaths.forEach(uploader::loadPhotoToMemory);
    }

    private static void loadPhotosToServer(GooglePhotosAutoUploader updater) {
        System.out.println("Загрузка фотографий в память приложения: ");
        try {
            updater.startAutoUploadPhotosToServer();
        } catch (InterruptedException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }


}
