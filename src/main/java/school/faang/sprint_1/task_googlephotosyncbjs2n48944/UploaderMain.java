package school.faang.sprint_1.task_googlephotosyncbjs2n48944;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class UploaderMain {
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
        Runnable addNewPhotoToUploader = () -> googlePhotosAutoUploader.addNewPhoto();
        Runnable autoUploadToServer = () -> {
            try {
                googlePhotosAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(3);
        scheduledExecutor.scheduleAtFixedRate(addNewPhotoToUploader,0, 3, TimeUnit.SECONDS);
        scheduledExecutor.scheduleAtFixedRate(autoUploadToServer,0, 1, TimeUnit.SECONDS);


//        new Thread(addNewPhotoToUploader).start();
//        new Thread(autoUploadToServer).start();
    }
}
