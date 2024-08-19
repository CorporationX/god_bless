package faang.school.godbless.task.multithreading.google.photo.sync;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        var pathToPhotos = List.of(
                "/disc/images/Photo_1",
                "/disc/images/Photo_2",
                "/disc/images/Photo_3",
                "/disc/images/Photo_4",
                "/disc/images/Photo_5",
                "/disc/images/Photo_6",
                "/disc/images/Photo_7",
                "/disc/images/Photo_8"
        );
        Thread uploadPhoto = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread addPhoto = new Thread(() -> {
            pathToPhotos.forEach(googlePhotosAutoUploader::onNewPhotoAdded);
        });
        uploadPhoto.start();
        addPhoto.start();
    }
}
