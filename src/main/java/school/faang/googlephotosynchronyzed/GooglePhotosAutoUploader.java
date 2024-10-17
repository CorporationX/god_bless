package school.faang.googlephotosynchronyzed;

import java.util.List;

public record GooglePhotosAutoUploader(Object lock, List<String> photosToUpload) {

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " поток запущен");
            while (photosToUpload.isEmpty()) {
                lock.wait();
            }
            uploadPhotos();
        }
    }

    private void uploadPhotos() {
        for (String pathPhoto : photosToUpload) {
            System.out.println("Загружено фото: " + pathPhoto);
        }
        System.out.println("Я поток: " + Thread.currentThread().getName());
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Я добавил путь к фото: " + Thread.currentThread().getName());
            lock.notifyAll();
        }
    }
}
