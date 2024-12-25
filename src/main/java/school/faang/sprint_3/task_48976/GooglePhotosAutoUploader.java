package school.faang.sprint_3.task_48976;

import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();

    private final List<String> photosToUpload;

    public GooglePhotosAutoUploader(List<String> photosToUpload) {
        this.photosToUpload = photosToUpload;
    }

    public void startAutoUpload(){
        synchronized(lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("Поток " + Thread.currentThread().getName() + " прервался");
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized(lock) {
            if (photoPath != null) {
                photosToUpload.add(photoPath);
                lock.notify();
            }
        }
    }

    private void uploadPhotos() {
        System.out.println("Начинается загрузка на сервер...");
        photosToUpload.forEach(System.out::println);
        photosToUpload.clear();
    }
}
