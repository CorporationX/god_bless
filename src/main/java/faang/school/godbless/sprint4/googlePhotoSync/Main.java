package faang.school.godbless.sprint4.googlePhotoSync;

import faang.school.godbless.sprint4.googlePhotoSync.classes.GooglePhotosAutoUploader;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread thread1 = new Thread(uploader::startAutoUpload);
        Thread thread2 = new Thread(() -> uploader.onNewPhotoAdded("photo1"));

        thread1.start();
        thread2.start();
    }
}
