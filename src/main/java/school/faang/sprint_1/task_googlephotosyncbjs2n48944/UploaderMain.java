package school.faang.sprint_1.task_googlephotosyncbjs2n48944;

import java.util.ArrayList;
import java.util.List;

public class UploaderMain {

    public static void main(String[] args) {
        List<String> pathsToPhotos = new ArrayList<>(List.of(
                "C:\\Photos\\Photo1.png",
                "C:\\Photos\\Photo2.png",
                "C:\\Photos\\Photo3.png"
        ));
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader(pathsToPhotos);
        Thread uploadThread = new Thread(() -> googlePhotosAutoUploader.startAutoUpload());
        Thread photoAdderThread = new Thread(() -> {
            googlePhotosAutoUploader.onNewPhotoAdded("Photo_001");
            googlePhotosAutoUploader.onNewPhotoAdded("Photo_002");
            googlePhotosAutoUploader.onNewPhotoAdded("Photo_003");
            googlePhotosAutoUploader.onNewPhotoAdded("Photo_004");
        });
        uploadThread.start();
        photoAdderThread.start();
    }
}

//Runnable autoUploadToServer = () -> googlePhotosAutoUploader.startAutoUpload();
//Runnable addNewPhotoToUploader =