package school.faang.googlephotosync;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {

        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread thread1 = new Thread(uploader::startAutoUpload);
        Thread thread2 = new Thread(() -> {
            uploader.onNewPhotoAdded("Photo1.jpg");
            uploader.onNewPhotoAdded("Photo2.jpg");
            uploader.onNewPhotoAdded("Photo3.jpg");
        });

        thread1.start();
        thread2.start();


    }
}