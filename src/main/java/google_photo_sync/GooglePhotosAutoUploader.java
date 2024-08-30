package google_photo_sync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();
    private final PhotosRepository photosRepository = new PhotosRepository();

    public void startUploadPhoto() {
        try {
            synchronized (lock) {
                while (true) {
                    if (photosToUpload.isEmpty()) {
                        lock.wait();
                    }
                    uploadPhotos();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void uploadPhotos() {
        int photosCount = photosToUpload.size();
        photosRepository.addPhotos(photosToUpload);
        System.out.printf("Успешно загружено фотографий: %d%n", photosCount);
        photosRepository.printInfoAboutRepo();
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void onNewPhotosAdded(List<String> photoPaths) {
        synchronized (lock) {
            photosToUpload.addAll(photoPaths);
            lock.notify();
        }
    }
}
