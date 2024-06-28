package faang.school.godbless.Google_Photo_sync;

import java.util.ArrayList;

public record GooglePhotosAutoUploader(Object lock, ArrayList<String> photosToUpload) {
    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                lock.wait();
            }
            uploadPhotos();
            lock.wait(10000);
        }
    }

    public void uploadPhotos() {
        System.out.println("Загружаем фотографии на Гугл сервер");
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}
