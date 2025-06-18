package school.faang.bjs2_81927;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread autoLoader = new Thread(googlePhotosAutoUploader::startAutoUpdate);
        autoLoader.start();

        Thread updatePhoto = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded("Путь"));
        updatePhoto.start();
    }
}
