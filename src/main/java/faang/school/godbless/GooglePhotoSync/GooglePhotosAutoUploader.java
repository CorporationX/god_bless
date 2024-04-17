package faang.school.godbless.GooglePhotoSync;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload;

    public void startAutoUpload() {
        synchronized (photosToUpload) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    try {
                        photosToUpload.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                photosToUpload.forEach(photo -> System.out.println("Photo " + photo + " has been uploaded"));
                photosToUpload.clear();
            }
        }
    }

    public void onNewPhotoAdded(List<String> photoPaths) {
        synchronized (photosToUpload) {
            photosToUpload.addAll(photoPaths);
            photosToUpload.notify();
        }
    }
}
