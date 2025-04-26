package school.faang.bjs2_73900;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread addPhoto = new Thread(() -> uploader.onNewPhotoAdded("/home/user/god_bless"));
        Thread uploadPhoto = new Thread(() -> uploader.uploadPhotos());

        uploadPhoto.start();
        addPhoto.start();

        try {
            addPhoto.join();
            uploadPhoto.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("All threads have finished.");
    }
}
