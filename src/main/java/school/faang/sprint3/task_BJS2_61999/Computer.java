package school.faang.sprint3.task_BJS2_61999;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Computer {
    private static final GooglePhotosAutoUploader GOOGLE_PHOTOS_AUTO_UPLOADER = new GooglePhotosAutoUploader();
    private static final ExecutorService ADD_PHOTO_THREAD = Executors.newFixedThreadPool(1);
    private static final ExecutorService UPLOAD_PHOTO_THREAD = Executors.newFixedThreadPool(1);
    private static final List<String> PATH_TO_PHOTOS = new ArrayList<>();

    public static void main(String[] args) {
        addNewPhoto("first");
        addNewPhoto("second");
        addNewPhoto("third");
        uploadPhotos();
        ADD_PHOTO_THREAD.shutdown();
        UPLOAD_PHOTO_THREAD.shutdown();
    }

    public static void addNewPhoto(String pathToPhoto) {
        PATH_TO_PHOTOS.add(pathToPhoto);
        ADD_PHOTO_THREAD.submit(() -> GOOGLE_PHOTOS_AUTO_UPLOADER.onNewPhotoAdded(pathToPhoto));
    }

    private static void uploadPhotos() {
        UPLOAD_PHOTO_THREAD.submit(GOOGLE_PHOTOS_AUTO_UPLOADER::startAutoUpload);
    }
}
