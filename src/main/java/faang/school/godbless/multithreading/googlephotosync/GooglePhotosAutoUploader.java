package faang.school.godbless.multithreading.googlephotosync;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GooglePhotosAutoUploader {
    private List<String> photosToUpload;
    private List<String> photosToServer;

    public GooglePhotosAutoUploader() {
        this.photosToUpload = new ArrayList<>();
        this.photosToServer = new ArrayList<>();
    }


    @SneakyThrows
    public void startAutoUpload() {
        synchronized (photosToUpload) {
            if (photosToUpload.isEmpty()) {
                photosToUpload.wait();
            }
            uploadPhotos();
        }
    }

    private void uploadPhotos() {
        photosToUpload = photosToUpload.stream()
                .peek(a -> photosToServer.add(a))
                .peek(a -> System.out.println("Load photos..." + a))
                .peek(a -> photosToUpload.remove(a))
                .toList();

    }

    public void onNewPhotoAdded(String string) {
        synchronized (photosToUpload) {
            photosToUpload.add(string);
            photosToUpload.notify();
        }
    }
}
