package school.faang.googlephotosync;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();
    private final Object lock = new Object();

    @SneakyThrows
    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        System.out.println("No new photos. Waiting for new photos to be added...");
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Upload process interrupted.");
                        return;
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("New photo added for upload: " + photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        synchronized (lock) {
            String uploadedPhotos = photosToUpload.stream()
                    .map(photo -> {
                        System.out.println("Uploading photo: " + photo);
                        return photo;
                    })
                    .collect(Collectors.joining(", "));
            System.out.println("All photos uploaded: " + uploadedPhotos);
            photosToUpload.clear();
        }
    }
}



