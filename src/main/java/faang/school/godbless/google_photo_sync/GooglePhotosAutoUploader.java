package faang.school.godbless.google_photo_sync;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<GooglePhoto> photosToUpload;

    @SneakyThrows
    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                lock.wait();
            }
            uploadPhotos();
        }
    }

    @SneakyThrows
    public void onNewPhotoAdded(GooglePhoto photoPath) {
        synchronized (lock) {
            System.out.println("Adding photo " + photoPath.getName() + " to photos...");
            photosToUpload.add(photoPath);
            Thread.sleep(new Random().nextInt(2_500));
            System.out.println(photoPath.getName() + " successfully added!\n");
            lock.notify();
        }
    }

    @SneakyThrows
    private void uploadPhotos() {
        synchronized (lock) {
            System.out.println("Uploading photos...");
            Thread.sleep(new Random().nextInt(5_500));
            photosToUpload.clear();
            System.out.println("Done!");
        }
    }
}
