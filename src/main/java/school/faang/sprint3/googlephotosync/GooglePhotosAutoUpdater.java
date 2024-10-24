package school.faang.sprint3.googlephotosync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUpdater {
    private final List<String> photosToUpload;
    private final Object loc = new Object();

    public GooglePhotosAutoUpdater() {
        this.photosToUpload = new ArrayList<>();
    }

    public void startAutoUpload() {
        synchronized (loc) {
            while (photosToUpload.isEmpty()) {
                try {
                    loc.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            uploadPhotos();
        }
    }

    private void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println("Загружаем фотографию: " + photo);
        }
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (loc) {
            photosToUpload.add(photoPath);
            loc.notify();
        }
    }
}
