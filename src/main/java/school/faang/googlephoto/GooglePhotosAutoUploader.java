package school.faang.googlephoto;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private static final int TIME_TO_WORK = 100;
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized(lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized(lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        for (String path : photosToUpload) {
            try {
                Thread.sleep(TIME_TO_WORK);
                System.out.println("Загружена фотография " + path);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        photosToUpload = new ArrayList<>();
    }
}