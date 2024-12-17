package school.faang.task_48862;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock;
    private final List<String> photosToUpload;

    public GooglePhotosAutoUploader() {
        this.lock = new Object();
        this.photosToUpload = new ArrayList<>();
    }

    public void startAutoUpload(int photosCount) {
        synchronized (lock) {
            int uploadedPhotosCount = 0;
            Supplier<Integer> uploadPhotos = () -> {
                try {
                    while (photosToUpload.isEmpty()) {
                        lock.wait();
                    }
                    return uploadPhotos();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };
            while (uploadedPhotosCount < photosCount) {
                uploadedPhotosCount += uploadPhotos.get();
            }
        }

    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    private int uploadPhotos() {
        photosToUpload.forEach(log::info);

        int photosCount = photosToUpload.size();
        photosToUpload.clear();

        return photosCount;
    }

}
