package google.photosync;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GooglePhotoAutoUploader {
    @NonNull
    private final Object lock;
    @NonNull
    private final List<String> photosToUpload;
    private volatile boolean serviceWorking = true;

    public void startAutoUpload() {
        try {
            synchronized (lock) {
                while (serviceWorking) {
                    if (photosToUpload.isEmpty()) {
                        System.out.println("Waiting for new photos to upload...");
                        lock.wait();
                    }
                    uploadPhoto(photosToUpload.remove(photosToUpload.size() - 1));
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void onNewPhotoAdded(@NonNull String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notifyAll();
        }
    }

    private void uploadPhoto(@NonNull String photoPath) {
        System.out.printf("Photo %s is upload%n", photoPath);
    }

    public void stopService() {
        serviceWorking = false;
    }
}
