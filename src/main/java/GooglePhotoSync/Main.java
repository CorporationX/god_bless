package GooglePhotoSync;

import lombok.SneakyThrows;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotos = new GooglePhotosAutoUploader();
        String pathToNewPhotos = "C:\\...";

        Thread uploadPhotoTread = new Thread(googlePhotos::startAutoUpload);
        Thread watchPhotoTread = new Thread(() -> googlePhotos.onNewPhotoAdded(pathToNewPhotos));

        uploadPhotoTread.start();
        watchPhotoTread.start();
    }
}
