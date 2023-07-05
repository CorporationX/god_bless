package faang.school.godbless.Sprint_4.Multithreading_Synchronization.GogglePhotoSync;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> photos = List.of("photo1", "photo2");
        List<String> photos2 = List.of("photo3", "photo4");
        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader(photos);

        Thread uploadThread = new Thread(googlePhoto::startAutoUpload);
        Thread watchThread = new Thread(() -> photos.stream().forEach(photo ->System.out.printf("You watch photo: %s\n", photo)));
        uploadThread.start();
        watchThread.start();

        photos2.stream().forEach(photo -> googlePhoto.onNewPhotoAdded(photo));
    }
}
