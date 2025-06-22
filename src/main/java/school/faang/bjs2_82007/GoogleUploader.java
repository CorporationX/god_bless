package school.faang.bjs2_82007;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GoogleUploader {
    public static void main(String[] args) {
        List<String> photosToUpload = new ArrayList<>(List.of(
                "C//User/1",
                "C//User/2",
                "C//User/3",
                "C//User/4",
                "C//User/5",
                "C//User/6",
                "C//User/7"
        ));

        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader(photosToUpload);
        Thread autoUpload = new Thread(() -> {
            for (String photoName : photosToUpload) {
                googlePhotosAutoUploader.startAutoUpload(photoName);
            }
        });
        autoUpload.start();
        Thread uploadPhotos = new Thread(() -> {
            googlePhotosAutoUploader.onNewPhotoAdded("C//User/8");
        });
        uploadPhotos.start();
    }
}
