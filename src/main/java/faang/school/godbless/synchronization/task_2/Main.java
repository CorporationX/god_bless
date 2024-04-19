package faang.school.godbless.synchronization.task_2;

import faang.school.godbless.synchronization.task_2.server.GooglePhoto;
import faang.school.godbless.synchronization.task_2.util.GooglePhotosAutoUploader;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int POOL_SIZE = 2;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(POOL_SIZE);

    public static void main(String[] args) {
        GooglePhoto googlePhoto = new GooglePhoto();
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader(googlePhoto);
        List<String> photos = getPhotos();
        EXECUTOR.submit(googlePhotosAutoUploader::startAutoUpload);
        EXECUTOR.submit(() -> photos.forEach(googlePhotosAutoUploader::onNewPhotoAdded));
        EXECUTOR.shutdown();

        googlePhoto.showPhoto();
    }

    private static List<String> getPhotos() {
        return List.of("path 1", "path 2", "path 3");
    }
}