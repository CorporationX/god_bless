package school.faang.sprint_1.task_googlephotosyncbjs2n48944;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class UploaderMain {
    @SneakyThrows
    public static void main(String[] args) {
        List<String> pathsToPhotos = new ArrayList<>(List.of(
                "C:\\Photos\\Photo1.png",
                "C:\\Photos\\Photo2.png",
                "C:\\Photos\\Photo3.png",
                "C:\\Photos\\Photo4.png",
                "C:\\Photos\\Photo5.png",
                "C:\\Photos\\Photo6.png"
        ));
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader(pathsToPhotos);
        Runnable addNewPhotoToUploader = () -> {
            googlePhotosAutoUploader.onNewPhotoAdded("Photo_001");
            googlePhotosAutoUploader.onNewPhotoAdded("Photo_002");
            googlePhotosAutoUploader.onNewPhotoAdded("Photo_003");
            googlePhotosAutoUploader.onNewPhotoAdded("Photo_004");
        };
        Runnable autoUploadToServer = () -> googlePhotosAutoUploader.startAutoUpload();


//        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(2);
//        scheduledExecutor.scheduleAtFixedRate(autoUploadToServer,0, 1, TimeUnit.SECONDS);
//        scheduledExecutor.scheduleAtFixedRate(addNewPhotoToUploader,0, 3, TimeUnit.SECONDS);


        Thread uploadThread = new Thread(autoUploadToServer);
        Thread photoAdderThread = new Thread(addNewPhotoToUploader);
        uploadThread.start();
        photoAdderThread.start();
//        new Thread(addNewPhotoToUploader).start();
//        new Thread(autoUploadToServer).start();

    }
}
