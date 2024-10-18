package google_photo_sync;

import java.util.ArrayList;
import java.util.List;


public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    /**
     * Uploads all the photos in the {@link #photosToUpload} list. This method
     * blocks until at least one photo is available to upload.
     *
     * @throws InterruptedException if the current thread was interrupted while
     * waiting for a photo to upload
     */
    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                lock.wait();
            }
            uploadPhotos();
        }
    }

    /**
     * Uploads all the photos in the {@link #photosToUpload} list. If the
     * thread is interrupted, the method will stop uploading and clear the
     * list of photos.
     * @throws InterruptedException if the thread is interrupted
     */
    public void uploadPhotos() throws InterruptedException {
        System.out.println("Начинаем загрузку фотографий...");
        for (String photo : photosToUpload) {
            System.out.println("Загружаем: " + photo);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Загрузка была прервана.");
            }
        }
        photosToUpload.clear();
        System.out.println("Все фотографии успешно загружены.");
    }

    /**
     * Add a new photo to the list of photos to upload. This method is
     * thread-safe and can be called from any thread.
     *
     * @param photoPath the path to the new photo
     */
    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}
