package faang.school.godbless.gphoto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws  InterruptedException {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        List <String> photosToAdd = new ArrayList<>();
        photosToAdd.add("Photo 1");
        photosToAdd.add("Photo 2");
        photosToAdd.add("Photo 3");
        photosToAdd.add("Photo 4");

        Thread uploadThread = new Thread(()->{
            try {
                googlePhotosAutoUploader.uploadPhotos();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        photosToAdd.forEach(photo->{
            Thread photoAdd = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded(photo));
            photoAdd.start();
        });
        uploadThread.start();
    }
}
