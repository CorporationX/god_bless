package faang.school.godbless.GooglePhotoSync;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();
        List<String> pathsToPhotos = List.of(
                "Sunny Beach",
                "Snowy Mountain",
                "City Lights",
                "Forest Trail",
                "Desert Sunset",
                "Ocean Waves",
                "Flower Garden",
                "Rainy Day",
                "Night Sky",
                "Historic Castle"
        );

        Thread uploadPhoto = new Thread(autoUploader::startUpAutoUpload);
        Thread viewPhoto = new Thread(() -> {
            for(String pathToPhoto : pathsToPhotos) {
                autoUploader.onNewPhotoAdded(pathToPhoto);
            }
        });

        uploadPhoto.start();
        viewPhoto.start();
    }
}
